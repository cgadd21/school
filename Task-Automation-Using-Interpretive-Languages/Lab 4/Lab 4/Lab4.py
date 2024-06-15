import matplotlib.pyplot as plt
import numpy as np

def read_apm(filename, data) :

	infile = open(filename, 'r')

	line = infile.readline()

	while line :
		line = line.strip()
		data.append(line.split(','))
		line = infile.readline()

	infile.close()

	for i in range(0, len(data)) : 
		data[i][0] = float(data[i][0])#seconds
		data[i][1] = float(data[i][1])#cpu (cpu plot)
		data[i][2] = float(data[i][2])#memory (memory plot)

def read_sys(filename, data) :

	infile = open(filename, 'r')

	line = infile.readline()

	while line :
		line = line.strip()
		data.append(line.split(','))
		line = infile.readline()

	infile.close()

	for i in range(0, len(data)) : 
		data[i][0] = float(data[i][0])#seconds
		data[i][1] = float(data[i][1])#rx (bandwidth)
		data[i][2] = float(data[i][2])#tx (bw)
		data[i][3] = float(data[i][3])#disk write (access)
		data[i][4] = int(data[i][4])#disk capacity (utilization)

APM1 = 'APM1_metrics.csv'
APM2 = 'APM2_metrics.csv'
APM3 = 'APM3_metrics.csv'
APM4 = 'APM4_metrics.csv'
APM5 = 'APM5_metrics.csv'
APM6 = 'APM6_metrics.csv'
SYS = 'system_metrics.csv'

data1=[]
data2=[]
data3=[]
data4=[]
data5=[]
data6=[]
dataS=[]

read_apm(APM1, data1)
read_apm(APM2, data2)
read_apm(APM3, data3)
read_apm(APM4, data4)
read_apm(APM5, data5)
read_apm(APM6, data6)
read_sys(SYS, dataS)

arr1 = np.array(data1)
arr2 = np.array(data2)
arr3 = np.array(data3)
arr4 = np.array(data4)
arr5 = np.array(data5)
arr6 = np.array(data6)
arrS = np.array(dataS)

#CPU plot

plt.plot(arr1[:, 1], color='blue', label='APM1')
plt.plot(arr2[:, 1], color='black', label='APM2')
plt.plot(arr3[:, 1], color='red', label='APM3')
plt.plot(arr4[:, 1], color='green', label='APM4')
plt.plot(arr5[:, 1], color='yellow', label='APM5')
plt.plot(arr6[:, 1], color='cyan', label='APM6')
plt.legend(loc='upper right')
plt.ylabel('CPU Utilization')
plt.xlabel('Seconds')
plt.title('CPU utilization by APM')
plt.savefig('cpu.png')
plt.close()


#Memory plot
plt.plot(arr1[:, 2], color='blue', label='APM1')
plt.plot(arr2[:, 2], color='black', label='APM2')
plt.plot(arr3[:, 2], color='red', label='APM3')
plt.plot(arr4[:, 2], color='green', label='APM4')
plt.plot(arr5[:, 2], color='yellow', label='APM5')
plt.plot(arr6[:, 2], color='cyan', label='APM6')
plt.legend(loc='upper right')
plt.ylabel('Memory Utilization')
plt.xlabel('Seconds')
plt.title('Memory utilization by APM')
plt.savefig('memory.png')
plt.close()

#Bandwidth plot

plt.plot(arrS[:, 1], color='yellow', label='RX')
plt.plot(arrS[:, 2], color='cyan', label='TX')
plt.legend(loc='upper right')
plt.ylabel('Bandwidth Utilization')
plt.xlabel('Seconds')
plt.title('Bandwidth utilization by RX and TX')
plt.savefig('bandwidth.png')
plt.close()

#Disk access plot 

plt.plot(arrS[:, 3], color='red', label='Hard Disk Access Rates')
plt.legend(loc='upper right')
plt.ylabel('Hard Disk Access Rates')
plt.xlabel('Seconds')
plt.title('Hard Disk Access Rates')
plt.savefig('disk_access.png')
plt.close()

#Disk utilization plot

plt.plot(arrS[:, 4], color='green', label='Hard Disk Utilization')
plt.legend(loc='upper right')
plt.ylabel('Hard Disk Utilization')
plt.xlabel('Seconds')
plt.title('Hard Disk Utilization')
plt.savefig('disk_util.png')
plt.close()
