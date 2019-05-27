import json

f = open('Surah.json')
data = json.load(f)
f.close()
dict={}
l=[]
for i in range(0,len(data)):
    s= {data[i]["title"] : data[i]["count"]}
    l.append(data[i]["count"])
    dict.update(s)



print(l)

