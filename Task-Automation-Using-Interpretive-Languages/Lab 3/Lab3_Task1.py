import sys
import math

def read_data(filename, L):	
	f=open(filename,'r')
	line=f.readline().strip()
	while line:
		line=f.readline()
		if("@DATA" in line):
			while line:
				line=f.readline().strip()
				if(line==""):
					break
				split_line=line.split(',')
				split_line[0]=float(split_line[0])
				split_line[1]=float(split_line[1])
				split_line[2]=float(split_line[2])
				split_line[3]=float(split_line[3])
				L.append(split_line)
	f.close()

def process_numeric_field(L, field_num):
	i=0
	data_min=100
	data_max=0
	data_sum=0
	data_squared_sum=0
	while i<len(L): 	
		field_data=(L[i][field_num-1])
		if(field_data<data_min):
			data_min=field_data
		if(field_data>data_max):
			data_max=field_data
		data_sum+=field_data
		data_squared_sum+=field_data **2
		i+=1
	data_avg=data_sum/len(L)
	data_variance=data_squared_sum/len(L)-data_avg**2
	data_std_dev=math.sqrt(data_variance)
	return data_min, data_max, data_avg, data_std_dev

def count_iris_types(L):
    setosa_count = 0
    versicolor_count = 0
    virginica_count = 0

    for sublist in L:
        if sublist[4] == "Iris-setosa":
            setosa_count += 1
        elif sublist[4] == "Iris-versicolor":
            versicolor_count += 1
        elif sublist[4] == "Iris-virginica":
            virginica_count += 1
    
    return setosa_count, versicolor_count, virginica_count


	

L=[]
filename=sys.argv[1]

read_data(filename, L)

min_value, max_value, avg_value, std_dev_value = process_numeric_field(L, 1)
print("Sepal Length: min = {}, max = {}, average = {:.2f}, standard deviation = {:.2f}".format(min_value, max_value, avg_value, std_dev_value))

min_value, max_value, avg_value, std_dev_value = process_numeric_field(L, 2)
print("Sepal Width: min = {}, max = {}, average = {:.2f}, standard deviation = {:.2f}".format(min_value, max_value, avg_value, std_dev_value))

min_value, max_value, avg_value, std_dev_value = process_numeric_field(L, 3)
print("Petal Length: min = {}, max = {}, average = {:.2f}, standard deviation = {:.2f}".format(min_value, max_value, avg_value, std_dev_value))

min_value, max_value, avg_value, std_dev_value = process_numeric_field(L, 4)
print("Petal Width: min = {}, max = {}, average = {:.2f}, standard deviation = {:.2f}".format(min_value, max_value, avg_value, std_dev_value))

num_iris_setosa, num_iris_versicolor, num_iris_virginica = count_iris_types(L)
print("Iris Types: Iris Setosa = {}, Iris Versicolor = {}, Iris Virginica = {}".format(num_iris_setosa, num_iris_versicolor, num_iris_virginica))

