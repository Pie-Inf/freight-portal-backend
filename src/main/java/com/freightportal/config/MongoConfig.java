package com.freightportal.config;

import com.freightportal.model.Fleet;
import com.freightportal.model.Load;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import jakarta.annotation.PostConstruct;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.geo.GeoJsonModule;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.IndexOperations;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;

@Configuration
@EnableMongoRepositories(basePackages = "com.freighthub.repository")
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Value("${spring.data.mongodb.database}")
    private String databaseName;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

    @Override
    public MongoClient mongoClient() {
        return MongoClients.create(mongoUri);
    }

    @Bean
    public MongoTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
        return new MongoTransactionManager(dbFactory);
    }

    @Override
    @Bean
    public MongoCustomConversions customConversions() {
        return new MongoCustomConversions(Arrays.asList(
                // Add custom converters if needed
        ));
    }

    @Override
    protected void configureConverters(MongoCustomConversions.MongoConverterConfigurationAdapter adapter) {
        adapter.registerConverter((Converter<?, ?>) new GeoJsonModule());
    }

    @PostConstruct
    public void initIndexes() {
        createIndexes();
    }

    private void createIndexes() {
        // Create indexes for Load collection
        IndexOperations loadIndexOps = mongoTemplate.indexOps(Load.class);

        // Compound index for common search patterns
        loadIndexOps.ensureIndex(
                new Index()
                        .on("status", Sort.Direction.ASC)
                        .on("pickupDate", Sort.Direction.ASC)
                        .on("createdAt", Sort.Direction.DESC)
        );

        // Geospatial indexes for location-based queries
        loadIndexOps.ensureIndex(
                new org.springframework.data.mongodb.core.index.GeospatialIndex("pickup.coordinates")
        );

        loadIndexOps.ensureIndex(
                new org.springframework.data.mongodb.core.index.GeospatialIndex("delivery.coordinates")
        );

        // Text index for searching cargo descriptions and notes
        loadIndexOps.ensureIndex(
                new org.springframework.data.mongodb.core.index.TextIndexDefinition.TextIndexDefinitionBuilder()
                        .onField("cargo.type")
                        .onField("cargo.description")
                        .onField("notes")
                        .onField("shipperName")
                        .build()
        );

        // Index for shipper queries
        loadIndexOps.ensureIndex(
                new org.springframework.data.mongodb.core.index.Index()
                        .on("shipperId", org.springframework.data.domain.Sort.Direction.ASC)
        );

        // Index for rate queries
        loadIndexOps.ensureIndex(
                new org.springframework.data.mongodb.core.index.Index()
                        .on("rate", org.springframework.data.domain.Sort.Direction.DESC)
        );

        // Create indexes for Fleet collection
        IndexOperations fleetIndexOps = mongoTemplate.indexOps(Fleet.class);

        // Compound index for fleet searches
        fleetIndexOps.ensureIndex(
                new Index()
                        .on("status", Sort.Direction.ASC)
                        .on("availableFrom", Sort.Direction.ASC)
                        .on("vehicle.type", Sort.Direction.ASC)
        );

        // Geospatial index for fleet location
        fleetIndexOps.ensureIndex(
                new org.springframework.data.mongodb.core.index.GeospatialIndex("currentLocation.coordinates")
        );

        // Index for carrier queries
        fleetIndexOps.ensureIndex(
                new org.springframework.data.mongodb.core.index.Index()
                        .on("carrierId", org.springframework.data.domain.Sort.Direction.ASC)
        );

        // Create indexes for User collection
        IndexOperations userIndexOps = mongoTemplate.indexOps(User.class);

        // Unique index for email
        userIndexOps.ensureIndex(
                new org.springframework.data.mongodb.core.index.Index()
                        .on("email", org.springframework.data.domain.Sort.Direction.ASC)
                        .unique()
        );

        // Index for user type and status
        userIndexOps.ensureIndex(
                new org.springframework.data.mongodb.core.index.Index()
                        .on("userType", org.springframework.data.domain.Sort.Direction.ASC)
                        .on("status", org.springframework.data.domain.Sort.Direction.ASC)
        );
    }

    @Override
    @Bean
    public MappingMongoConverter mappingMongoConverter(MongoDatabaseFactory databaseFactory,
                                                       MongoCustomConversions customConversions,
                                                       MongoMappingContext mappingContext) {
        MappingMongoConverter converter = new MappingMongoConverter(
                new org.springframework.data.mongodb.core.convert.DefaultDbRefResolver(databaseFactory),
                mappingContext
        );

        converter.setCustomConversions(customConversions);

        // Remove the _class field from documents
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));

        return converter;
    }

    // Helper method to drop and recreate indexes (for development)
    public void recreateIndexes() {
        mongoTemplate.indexOps(Load.class).dropAllIndexes();
        mongoTemplate.indexOps(Fleet.class).dropAllIndexes();
        mongoTemplate.indexOps(User.class).dropAllIndexes();

        createIndexes();
    }

    // Health check method
    public boolean isDatabaseConnected() {
        try {
            mongoTemplate.execute(db -> {
                db.runCommand(new org.bson.Document("ping", 1));
                return "ok";
            });
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}