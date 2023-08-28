f = open("ESoutput_NonRequest_ori.txt","r")
f1 = open("ESoutput_NonRequest_final.txt","w")

line = f.readline()
while line:
    
    if "Transforming: " in line:
        ActName = line.strip().split("Transforming: ")[1]
        print(ActName)
        f1.writelines(ActName + "\n")
    line = f.readline()