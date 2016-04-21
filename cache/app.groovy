import java.util.concurrent.atomic.AtomicLong

@Configuration
@EnableCaching
class App implements CommandLineRunner {

	@Bean CacheManager cacheManager() {
		new ConcurrentMapCacheManager()
	}
    
    @Autowired
    private final MyService myService

    @Override
    void run(String... args) { 
        long counter = myService.get('someKey')
        long counter2 = myService.get('someKey')
        if (counter == counter2) {
            println "Hello World $counter"
        } else {
            println "Something went wrong with the cache setup $counter and $counter2"
        }
    }

}

@Component
 class MyService {

    private final AtomicLong counter = new AtomicLong(1)

    @Cacheable('foo')
    Long get(String id) {
        return counter.getAndIncrement()
    }

}