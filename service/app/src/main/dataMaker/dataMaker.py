# parameter
# @humanflow : 5000-100000(大部分在20000-50000)/3
# arr = []
# 20000*10000/6
# 1656738000 时间从7/2 13:00开始
# import time
# print(time.time())
# print(time.gmtime(time.time()))
import random


def lef():
    return random.randint(5000, 30000) / 3


def mid():
    return random.randint(30000, 50000) / 3


def rig():
    return random.randint(50000, 100000) / 2


nowTime = str(1656738000)
now = m = int(rig())
nRig = m * 2
nMid = int(mid()) * 2
r = 3.0
nt = mt = 1656738000


def getNowFlow():
    global m
    op = random.randint(1, 100)
    if 20 <= op <= 80:
        m += random.randint(-20, 20)
    else:
        m += random.randint(-80, 80)
    return str(m)


def getNowRate():
    global r
    op = random.randint(1, 100)
    if 0 <= op <= 50:
        r += random.random() * -0.03
    else:
        r += random.random() * 0.03
    return round(r, 3)


def getNowStamp():
    global mt
    mt += 1
    return str(mt)


def getHistStamp():
    global nt
    nt -= 3600
    return str(nt)


def getHistFlow():
    global nRig, nMid, nt
    nRig += random.randint(-1000, 1000)
    nMid += random.randint(-1000, 1000)
    if nt > 1656651600:
        return str(nRig)
    elif 1656565200 < nt < 1656651600:
        return str(int(nRig / 3 + nMid / 2))
    else:
        return str(nMid)


# ------------------------------------------------------------------------------------------------------------------------------------

with open("nowFlows.txt", "w") as f:
    for i in range(3600):
        S = "{" \
            "errcode: \"0.0\"," \
            "errmsg: \"\"," \
            "data: [" \
            "{" \
            "targetName: \"humanflow\"," \
            "counts: [" \
            "{" \
            "count: \"" + getNowFlow() + "\"," \
                                         "stamp: " + getNowStamp() + \
            "}" \
            "]" \
            "}," \
            "{" \
            "targetName: \"ReVisitedRate\"," \
            "counts: [" \
            "{" \
            "count: \"" + str(getNowRate()) + "\"," \
                                              "stamp: " + str(mt) + \
            "}" \
            "]" \
            "}" \
            "]" \
            "}\n"
        f.write(S)

# ------------------------------------------------------------------------------------------------------------------------------------

with open("histFlow.txt", "w") as f:
    for i in range(168):
        S = "{" \
            "errcode: \"0.0\"," \
            "errmsg: \"\"," \
            "data: [" \
            "{" \
            "targetName: \"humanflow\"," \
            "counts: [" \
            "{" \
            "count: \"" + getHistFlow() + "\"," \
                                          "stamp: " + getHistStamp() + \
            "}" \
            "]" \
            "}," \
            "{" \
            "targetName: \"ReVisitedRate\"," \
            "counts: [" \
            "{" \
            "count: \"" + str(getNowRate()) + "\"," \
                                              "stamp: " + str(nt) + \
            "}" \
            "]" \
            "}" \
            "]" \
            "}\n"
        f.write(S)

arr = []
for i in range(6):
    arr.append(now / 6)
r1 = random.randint(1000, 5000)
r2 = random.randint(1000, 5000)
r3 = random.randint(1000, 5000)
arr[0] -= r1
arr[5] += r1
arr[1] += r2
arr[2] -= r2
arr[3] -= r3
arr[4] += r3

# ------------------------------------------------------------------------------------------------------------------------------------


with open("sitesFlow.txt", "w") as f:
    for i in range(6):
        S = "{" \
            "errcode: \"0.0\"," \
            "errmsg: \"\"," \
            "data: [" \
            "{" \
            "targetName: \"humanflow\"," \
            "counts: [" \
            "{" \
            "count: \"" + str(int(arr[i])) + "\"," \
                                             "stamp: " + nowTime + \
            "}" \
            "]" \
            "}," \
            "{" \
            "targetName: \"ReVisitedRate\"," \
            "counts: [" \
            "{" \
            "count: \"" + str(round(getNowRate() * (1.2 if random.random() > 0.5 else 0.7), 3)) + "\"," \
                                                                                                  "stamp: " + nowTime + \
            "}" \
            "]" \
            "}" \
            "]" \
            "}\n"
        f.write(S)

# ------------------------------------------------------------------------------------------------------------------------------------

with open("sitesWlan.txt", "w") as f:
    for i in range(6):
        S = "{" + \
            "errcode: \"0.0\"," + \
            "errmsg: \"\"," + \
            "totalRecords: 0," + \
            "data: [" + \
            "{" + \
            "timestamp: " + nowTime + "," + \
            "unit: \"Mbps\"," + \
            "uplinkRate: " + str(round(arr[i] * (1.2 if random.random() > 0.5 else 0.7), 1)) + "," + \
            "downlinkRate: " + str(round(arr[i] * (1.8 if random.random() > 0.5 else 1.4), 1)) + \
            "}" + \
            "]" + \
            "}\n"
        f.write(S)

# ------------------------------------------------------------------------------------------------------------------------------------
deviceId = ["d13ca36d-fe68-48ae-b183-35cd77e97509",
            "2ad93214-8e16-4d54-b98a-febb232c68b1",
            "b6d0c896-4363-44f0-be41-01fde48f0751",
            "62d4090c-15a2-4c88-b5cb-d874d856a8f6",
            "74d7b89d-4f35-426d-9abc-ccfc3602d947",
            "b59c04a7-82b6-458b-8136-7623515ea232",
            "fc05c986-0e02-4512-bbd7-c1d9b7c1d19f",
            "ca2d6066-41d1-4366-9b99-131a0d0d60d5",
            "9a50b553-2eac-4d62-85dd-b4864010d7c0",
            "efcecd63-d38c-4dc7-961e-4073b5d05fc3",
            "8724e3b7-35b1-48e8-9f43-9172627db6cf",
            "a0fbfe32-0754-445f-8b05-df3011c718ae",
            "99b11c75-bea8-4759-b686-431bc831b6ef",
            "e6727817-f5ca-4791-963d-954986dcc088",
            "27387434-299c-4c1d-9837-361e21267500",
            "fcee947f-58d3-4e66-8e6a-063ef9ec2a9e",
            "bde7e24e-e8f4-4a39-9272-39d14dd4e2b8",
            "b491a2a9-18a5-434f-b494-4793a3a267b0",
            "1a56c83f-4b90-471c-902e-fcfbfa6f5a8c",
            "5b97470f-f8ca-41de-a836-0ec6d49d3deb",
            "ba29b07d-bf84-40cf-b15b-4ecd08e8a0cd",
            "82aef031-20ca-474d-90a9-936046501567",
            "ba5a38d8-0353-4d57-b76c-a32305a3cf1a",
            "c4a00229-e06d-43ea-aded-c9388a61d2fd",
            "cdbc4240-bfeb-4298-b009-1082d4201a95"]
with open("deviceWlan.txt", "w") as f:
    for i in range(len(deviceId)):
        temp = random.randint(500, 1000)/1000
        S = "{" + \
            "errcode: \"0.0\"," + \
            "errmsg: \"\"," + \
            "data: [" + \
            "{" + \
            "deviceId: \"" + deviceId[i] + "\"," + \
            "deviceName: \"device" + str(i) + "\"," + \
            "upTraffic: " + str(round(arr[int(i/5)] / 4 * (0.3+temp if random.random() > 0.5 else 0.6+temp), 1)) + "," + \
            "downTraffic: " + str(round(arr[int(i/5)] / 4 * (0.7+temp if random.random() > 0.5 else 1+temp), 1)) + "," + \
            "unit: \"Mbps\"" + \
            "}" + \
            "]" + \
            "}\n"
        f.write(S)