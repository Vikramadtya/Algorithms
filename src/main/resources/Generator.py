import random

count= 10000
repeat = 100

random.seed(13)

for i in range(10,count,10):
    for j in range(repeat):
        sequence = []
        for k in range(i):
           sequence.append(random.randint(1,2147483646))
        for x in sequence:
            print(x,end=" ")
        print()