class User:
    def login(self):
        print('login method invoked')

    def logout(self):
        print('logout method invoked')


class Proxy:

    def __init__(self, target):
        self.target = target

    def __getattribute__(self, name):
        target = object.__getattribute__(self, 'target') # 'target'是成员变量的名称
        attr = object.__getattribute__(target, name)
        if name == 'login':
            def newFunc(*args, **kwargs):
                print('login start')
                result = attr(*args, **kwargs)
                print('login end')
                return result

            return newFunc
        else:
            return attr


user = User()
proxy = Proxy(user)

proxy.login()
proxy.logout()
