from types import FunctionType


class User:
    def login(self):
        print('login method invoked')



methods = [x for x, y in User.__dict__.items() if type(y) == FunctionType]
print(methods)

user = globals()['User']()
func = getattr(user, 'login')
func()
