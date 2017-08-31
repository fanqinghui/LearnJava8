package com.wish;

import com.google.common.util.concurrent.*;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * @author fqh
 * @email fanqinghui100@126.com
 * @date 2017/8/24 15:00
 */
public class GuavaTest {

    ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

    @Test
    public void test() {
        ListenableFuture<String> listenableFuture = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                int i = 1;
                i = i / 0;
                Thread.sleep(1000);
                return "good luck!!!";
            }
        });


        Futures.addCallback(listenableFuture, new FutureCallback<String>() {

            @Override
            public void onSuccess(String s) {
                System.out.println(s + " onSuccess");
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println(" onFailure:" + throwable.getMessage());
            }
        });


        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test2() throws ExecutionException, InterruptedException {
        ListenableFuture<String> listenableFuture = executorService.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                return "good luck!!!";
            }
        });
        ListenableFuture<String> listenableFuture2=Futures.transformAsync(listenableFuture, new AsyncFunction<String, String>() {
            @Override
            public ListenableFuture<String> apply(String input) throws Exception {
                System.out.println("input:" + input);
                return Futures.immediateCheckedFuture("fqh");
            }
        });
        System.out.println(listenableFuture2.get());

    }

    ListeningExecutorService service=MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(3));

}
