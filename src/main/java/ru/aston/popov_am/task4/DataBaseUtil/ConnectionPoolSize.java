package ru.aston.popov_am.task4.DataBaseUtil;

public enum ConnectionPoolSize {
    INITIAL_POOL_SIZE(10);
    private int poolSize;

    ConnectionPoolSize(int poolSize) {
        this.poolSize=poolSize;
    }

    public int getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }
}
