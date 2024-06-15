import math

def read_txt(filename, data) :

	infile = open(filename, 'r')

	line = infile.readline()

	while line :
		line = line.strip()
		data.append(line.split(','))
		line = infile.readline()

	infile.close()

	for i in range(0, len(data)) : 
		data[i][0] = float(data[i][0])#x
		data[i][1] = float(data[i][1])#y

def distance(p1, p2):
	return math.sqrt((p2[0]-p1[0])**2 + (p2[1]-p1[0])**2)

def calc_closest(A, B) :
	closest=[]
	for i in range(len(A)):
		min_distance = 100
		min_index = -1
		for j in range(len(B)):
			d = distance(A[i], B[j])
			if d < min_distance:
				min_distance = d
				min_index = j
		closest.append((min_distance, min_index))
	return closest

def calc_furthest(A, B) :
	furthest=[]
	for i in range(len(A)):
		max_distance = 0
		max_index = None
		for j in range(len(B)):
			d = distance(A[i], B[j])
			if d > max_distance:
				max_distance = d
				max_index = j
		furthest.append((max_distance, max_index))
	return furthest

A = 'A.txt'
B = 'B.txt'

AData = []
BData = []

read_txt(A, AData)
read_txt(B, BData)

closest_points = calc_closest(AData, BData)

furthest_points = calc_furthest(AData, BData)

for i in range (len(AData)):
	print(f"Point {i+1} in A: {AData[i]}")
	print(f"Closest point in B: {BData[closest_points[i][1]]}")
	print(f"Distance between points: {closest_points[i][0]:.2f}")
	print()

for i in range (len(AData)):
	print(f"Point {i+1} in A: {AData[i]}")
	print(f"Furthest point in B: {BData[furthest_points[i][1]]}")
	print(f"Distance between points: {furthest_points[i][0]:.2f}")
	print()
