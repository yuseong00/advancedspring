package hello.pureproxy.trace.callback;

public interface TraceCallback<T> {
    T call();
}
