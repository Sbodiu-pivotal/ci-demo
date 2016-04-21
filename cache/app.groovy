import java.util.concurrent.atomic.AtomicLong

@Configuration
@EnableCaching
class App implements CommandLineRunner {

	@Bean CacheManager cacheManager() {
		new ConcurrentMapCacheManager()
	}
    
    @Autowired
    private final Metrics metrics

    @Override
    void run(String... args) { 
        long counter = metrics.count('hello')
        if (counter != metrics.count('hello')) {
            throw new RuntimeException("Something went wrong with the cache setup")
        }
        println "Hello World " + metrics.count('hello') + " " + metrics.count('world')
    }

}

@Component
class Metrics {

    private final AtomicLong counter = new AtomicLong(1)

    @Cacheable('metrics')
    Long count(String id) {
        return counter.getAndIncrement()
    }

}