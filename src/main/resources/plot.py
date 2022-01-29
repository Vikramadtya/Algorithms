import matplotlib.pyplot as plt
import numpy as np

f = open("./QuickSort_out.txt",'r')
f_1 = open("./MergerSort_out.txt",'r')

x_axis = []
y_axis = []

dictionary_1 = {}
for x in f_1:
    line = x.rstrip('\n').split("\t")
    if not line[0] in dictionary_1:
        dictionary_1[line[0]] = []
    dictionary_1[line[0]].append(int(line[1]))

for x in dictionary_1:
    dictionary_1[x] = sum(dictionary_1[x])/len(dictionary_1[x])

dictionary = {}
for x in f:
    line = x.rstrip('\n').split("\t")
    if not line[0] in dictionary:
        dictionary[line[0]] = []
    dictionary[line[0]].append(int(line[1]))

for x in dictionary:
    dictionary[x] = sum(dictionary[x])/len(dictionary[x])

for x in dictionary:
    x_axis.append(int(x))
    y_axis.append(int(dictionary[x]))
plt.ylim(0, 4000000)
# plt.xticks(np.arange(0, 10000, 500))
plt.yticks(np.arange(0, 4000000, 20000))
plt.plot(x_axis, y_axis)
plt.show()
