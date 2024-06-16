import sys

def parse(filename):
    metrics = []
    with open(filename, 'r') as doc:
        for line in doc:
                newline = doc.readline().strip()
                parts = newline.split()
                if len(parts) >= 8 and parts[4] == "ICMP":
                    time = float(parts[1])
                    source = parts[2]
                    dest = parts[3]
                    protocol = parts[4]
                    length = int(parts[5])
                    ttl = int((parts[11])[4:7])
                    info = ' '.join(parts[6:9])
                    metrics.append((time, source, dest, protocol, length, ttl, info))
    return metrics