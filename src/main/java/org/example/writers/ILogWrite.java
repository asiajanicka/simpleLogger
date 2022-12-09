package org.example.writers;

public interface ILogWrite {
    void write(String message);

    void write(String message, Throwable e);
}
