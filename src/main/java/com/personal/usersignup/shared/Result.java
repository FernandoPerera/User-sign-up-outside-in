package com.personal.usersignup.shared;

import java.util.Optional;
import java.util.function.Function;

public class Result<E, T> {

    private T result;
    private E error;
    private  boolean isError = false;

    public <U> Result<E, U> map(Function<? super E, ? extends E> errorMapper, Function<? super T, ? extends U> successMapper) {
        if (isError) {
            return Result.error(errorMapper.apply(error));
        } else {
            return Result.success(successMapper.apply(result));
        }
    }

    public static <E, T> Result<E, T> error(E error) {
        Result<E, T> result = new Result<>();
        result.isError = true;
        result.error = error;
        return result;
    }

    public static <E, T> Result<E, T> success(T value) {
        Result<E, T> result = new Result<>();
        result.result = value;
        return result;
    }

    public boolean isError() {
        return isError;
    }

    public E getError() {
        return error;
    }

    public T getResult() {
        return result;
    }
}
