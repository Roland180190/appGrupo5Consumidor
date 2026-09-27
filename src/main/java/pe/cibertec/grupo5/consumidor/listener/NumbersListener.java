package pe.cibertec.grupo5.consumidor.listener;

import pe.cibertec.grupo5.consumidor.config.RabbitMqConfig;
import pe.cibertec.grupo5.consumidor.service.MergeSortService;
import pe.cibertec.grupo5.consumidor.service.NumberParserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class NumbersListener {

    private static final Logger log = LoggerFactory.getLogger(NumbersListener.class);

    private final MergeSortService mergeSortService;
    private final NumberParserService numberParserService;

    public NumbersListener(
            MergeSortService mergeSortService,
            NumberParserService numberParserService) {
        this.mergeSortService = mergeSortService;
        this.numberParserService = numberParserService;
    }

    @RabbitListener(queues = RabbitMqConfig.QUEUE_NAME)
    public void receiveNumbers(String cadenaNumeros) throws InterruptedException {
        Integer[] integerArray = numberParserService.parse(cadenaNumeros);

        Thread.sleep(20_000);

        Integer[] sortedArray = mergeSortService.sort(integerArray);
        log.info("Lista ordenada: {}", Arrays.toString(sortedArray));
    }
}
