package com.njustxz.Queue;

/**
 * 自定义空队列异常
 *  运行时异常，不需要开发人员进行预处理
 */
public class QueueEmptyException extends RuntimeException {
    public QueueEmptyException() {
        super();
    }

    public QueueEmptyException(String message) {
        super(message);
    }
}
