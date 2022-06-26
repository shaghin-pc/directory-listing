from os.path import dirname, join

def main():

    filename = join("src/main/python/dataset.txt")
    with open(filename,'r',encoding='utf8',errors="ignore") as fin:
        data=fin.readlines()
        for i in data:
            return i
    #print(data)