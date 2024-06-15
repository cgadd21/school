import sys

def read_md5(filename):
	md5_list=[]
	f=open(filename,'r')
	next(f)
	for line in f:
		part=line.strip().split()
		md5_list.append({'name': part[0], 'md5': part[1]})
	f.close()
	return md5_list

def compare_md5(md5_n, md5_o):
	for i in range(len(md5_n)):
		for j in range(len(md5_o)):

			if md5_n[i]['name']==md5_o[j]['name'] and md5_n[i]['md5']!=md5_o[j]['md5']:

				print(f"{md5_n[i]['name']}: MD5 original = {md5_o[j]['md5']}, MD5 new = {md5_n[i]['md5']}\n")

md5_new_list=read_md5(sys.argv[1])
md5_original_list=read_md5(sys.argv[2])
compare_md5(md5_new_list, md5_original_list)
