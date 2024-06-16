from filter_packets import *
from packet_parser import *
from compute_metrics import *

f1 =open('Node1_filtered.txt','w')
filtered1 = []
filter('Node1.txt',filtered1)
for instance in filtered1:
    f1.write(instance)
f1.close()

f2 =open('Node2_filtered.txt','w')
filtered2 = []
filter('Node2.txt',filtered2)
for instance in filtered2:
    f2.write(instance)
f2.close()

f3 =open('Node3_filtered.txt','w')
filtered3 = []
filter('Node3.txt',filtered3)
for instance in filtered3:
    f3.write(instance)
f3.close()

f4 =open('Node4_filtered.txt','w')
filtered4 = []
filter('Node4.txt',filtered4)
for instance in filtered4:
    f4.write(instance)
f4.close()


Node1Ip = str("192.168.100.1")
Node2Ip = str("192.168.100.2")
Node3Ip = str("192.168.200.1")
Node4Ip = str("192.168.200.2")



parsed1 = parse('Node1_filtered.txt')
computed1 = compute(parsed1, Node1Ip)
print(computed1)

parsed2 = parse('Node2_filtered.txt')
computed2 = compute(parsed2, Node2Ip)
print(computed2)

parsed3 = parse('Node3_filtered.txt')
computed3 = compute(parsed3, Node3Ip)
print(computed3)

parsed4 = parse('Node4_filtered.txt')
computed4 = compute(parsed4, Node4Ip)
print(computed4)



