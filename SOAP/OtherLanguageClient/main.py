# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.

from zeep import Client

# Press the green button in the gutter to run the script.
if __name__ == '__main__':

    client = Client('http://localhost:8080/WebGlass-1.0/HelloWorldImplService?WSDL')
    result = client.service.getProducts()

    print(result)

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
