
f = open("ActionName_ori.txt", "r")



package=""
line = f.readline()
while line:
    line = f.readline()
    k = 0
    for i in line:  #12
        if i == " ":
            k+=1
        else:
            break
    
    if k == 12 :
        lineaarry = line.strip().split("  (")
        package = lineaarry[0]
    
    elif k == 16:
        if ".java" in line:
            lineaarry = line.strip().split(".java")
            classname = lineaarry[0]
            ClassName = "\"" + package + "." + classname + "\","
        else:
            lineaarry = line.strip().split("  (")
            classname = lineaarry[0]
            ClassName = "Plugin: " + "\"" + package + "." + classname + "\","
        
        
        print(ClassName)
        
        ###没考虑内部类