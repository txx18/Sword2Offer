from time import time


def timer(func):
    def f(x, y=10):
        before = time()
        rv = func(x, y)
        after = time()
        print(after - before)
        return rv

    return f


def add(x, y=10):
    return x + y


add = timer(add)


def sub(x, y=10):
    return x - y


sub = timer(sub)


def timer(func):
    def f(*args, **kwargs):
        before = time()
        rv = func(*args, **kwargs)
        after = time()
        print("time taken: ", after - before)
        return rv

    return f


@timer
def add(x, y=10):
    return x + y


@timer
def sub(x, y=10):
    return x - y



def ntimes(n):
    def inner(f):
        def wrapper(*args, **kwargs):
            for _ in range(n):
                rv = f(*args, **kwargs)
            return rv

        return wrapper

    return inner


@ntimes(3)
def add(x, y):
    print(x + y)
    return x + y

# 居然影响别的模块
# add(1, 2)
