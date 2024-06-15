from scapy.all import *
packets = rdpcap('example.pcap')#load entire pcap to memory

#How many ICMP Echo requests/replies did this node receive from 192.168.200.1?

ip_address = '192.168.200.1'
icmp_echo_requests = 0
icmp_echo_replies = 0

for packet in packets:
	if packet.haslayer(ICMP) and packet[IP].src == ip_address:
		if packet[ICMP].type == 8: # ICMP Echo Request
			icmp_echo_requests += 1
		elif packet[ICMP].type == 0: # ICMP Echo Reply
			icmp_echo_replies += 1

print("Query 1")
print(f"Number of ICMP Echo requests received from {ip_address}: {icmp_echo_requests}")
print(f"Number of ICMP Echo replies received from {ip_address}: {icmp_echo_replies}")
print()

#How much ICMP Echo request data/bytes did this node receive from 192.168.200.1?

ip_address = '192.168.200.1'
icmp_echo_request_bytes = 0
icmp_echo_request_packets = 0

for packet in packets:
	if packet.haslayer(ICMP) and packet[IP].src == ip_address:
		if packet[ICMP].type == 8: # ICMP Echo Request
			icmp_echo_request_bytes += len(packet)
			icmp_echo_request_packets+=1

icmp_echo_request_data = icmp_echo_request_bytes - (icmp_echo_request_packets*42)

print("Query 2")
print(f"Number of ICMP Echo request bytes received from {ip_address}: {icmp_echo_request_bytes}")
print(f"Number of ICMP Echo request data received from {ip_address}: {icmp_echo_request_data}")
print()

#How many ICMP Echo requests/replies did this node send to 192.168.100.1?

src_ip_address = '192.168.200.1'
dst_ip_address = '192.168.100.1'
icmp_echo_requests = 0
icmp_echo_replies = 0

for packet in packets:
	if packet.haslayer(ICMP) and packet[IP].src == src_ip_address and packet[IP].dst == dst_ip_address:
		if packet[ICMP].type == 8: # ICMP Echo Request
			icmp_echo_requests += 1
		elif packet[ICMP].type == 0: # ICMP Echo Reply
			icmp_echo_replies += 1

print("Query 3")
print(f"Number of ICMP Echo requests sent from {src_ip_address} to {dst_ip_address}: {icmp_echo_requests}")
print(f"Number of ICMP Echo replies sent from {src_ip_address} to {dst_ip_address}: {icmp_echo_replies}")
print()

#How much ICMP Echo request/reply data/bytes did this node send to 192.168.100.1?

src_ip_address = '192.168.200.1'
dst_ip_address = '192.168.100.1'
#icmp_echo_request_reply_bytes = 0
icmp_echo_request_bytes = 0
icmp_echo_reply_bytes = 0
#icmp_echo_request_reply_packets = 0
icmp_echo_request_packets = 0
icmp_echo_reply_packets = 0

for packet in packets:
	if packet.haslayer(ICMP) and packet[IP].src == src_ip_address and packet[IP].dst == dst_ip_address:
		#if packet[ICMP].type in [0, 8]: # ICMP Echo Request or Reply
			#icmp_echo_request_reply_bytes += len(packet)
			#icmp_echo_request_reply_packets+=1
		if packet[ICMP].type == 8: # ICMP Echo Request
			icmp_echo_request_bytes += len(packet)
			icmp_echo_request_packets += 1
		elif packet[ICMP].type == 0: # ICMP Echo Reply
			icmp_echo_reply_bytes += len(packet)
			icmp_echo_reply_packets += 1
			

#icmp_echo_request_reply_data = icmp_echo_request_reply_bytes - (icmp_echo_request_reply_packets*42)

icmp_echo_request_data = icmp_echo_request_bytes - (icmp_echo_request_packets*42)
icmp_echo_reply_data = icmp_echo_reply_bytes - (icmp_echo_reply_packets*42)

#print(f"Number of ICMP Echo request/reply bytes sent from {src_ip_address} to {dst_ip_address}: {icmp_echo_request_reply_bytes}")
#print (f"Number of ICMP Echo request/reply data sent from {src_ip_address} to {dst_ip_address}: {icmp_echo_request_reply_data}")

print("Query 4")
print(f"Number of ICMP Echo request bytes sent from {src_ip_address} to {dst_ip_address}: {icmp_echo_request_bytes}")
print(f"Number of ICMP Echo request data sent from {src_ip_address} to {dst_ip_address}: {icmp_echo_request_data}")
print(f"Number of ICMP Echo reply bytes sent from {src_ip_address} to {dst_ip_address}: {icmp_echo_reply_bytes}")
print(f"Number of ICMP Echo reply data sent from {src_ip_address} to {dst_ip_address}: {icmp_echo_reply_data}")
print()
