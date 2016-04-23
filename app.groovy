package org.test

import java.util.concurrent.CountDownLatch

@EnableReactor
@Log
class Runner implements CommandLineRunner {

	@Autowired
	EventBus eventBus

	private CountDownLatch latch = new CountDownLatch(1)

	@PostConstruct
	void init() {
		log.info "Registering consumer"
	}

	void run(String... args) {
		eventBus.notify("hi", Event.wrap("World"))
		log.info "Notified World"
		latch.await()
	}

	@Bean
	CountDownLatch latch() {
		latch
	}

}

@Consumer
@Log
class Greeter {

	@Autowired
	EventBus eventBus

	@Autowired
	private CountDownLatch latch

	@Selector(value="hi")
	void receive(String data) {
		log.info "Hello ${data}"
		latch.countDown()
	}

}
