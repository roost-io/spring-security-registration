

 java
public class DatabaseReaderClass {
    public DatabaseReader databaseReader() {
        File database = ResourceUtils.getFile("classpath:maxmind/GeoLite2-City.mmdb");
        return new DatabaseReader.Builder(database).build();
    }
}
