def filter(filename,filtered) :
	infile = open(filename, 'r')
	line = infile.readline()
	isEcho = False
	packet = ""
	while line :
		if((line[0:3] != ('No.'))) :
			packet = packet + "\n"+ line
			if(line.find('Echo') >= 0) :
				isEcho = True
			line = infile.readline()
		elif((line[0:3] == ('No.'))):
			if(isEcho) :
				filtered.append(packet)
				isEcho = False
			packet = ""
			packet = packet + "\n"+ line
			line = infile.readline()
#main
filtered = []