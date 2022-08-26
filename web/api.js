import axios from 'axios'
export async function hello() {
    return 'hello'
}
export async function getDeviceDetail() {
    var responseJson = ''
    await axios.post('http://localhost:2333/deviceDetail', '').then(
        (response) => {
            responseJson = response.data
        },
        (error) => {
            console.log('请求失败了', error.message)
        }
    )
    return responseJson
}
export async function getDeviceDetailByName(deviceName) {
    var responseJson = ''
    await axios
        .post('http://localhost:2333/deviceDetailByName', 'name=' + deviceName)
        .then(
            (response) => {
                responseJson = response.data
            },
            (error) => {
                console.log('请求失败了', error.message)
            }
        )
    return responseJson
}
export async function getDeviceTraffic() {
    var responseJson = ''
    await axios.post('http://localhost:2333/deviceTraffic', '').then(
        (response) => {
            responseJson = response.data
        },
        (error) => {
            console.log('请求失败了', error.message)
        }
    )
    return responseJson
}
export async function getHistFlow() {
    var responseJson = ''
    await axios.post('http://localhost:2333/histFlow', '').then(
        (response) => {
            responseJson = response.data
        },
        (error) => {
            console.log('请求失败了', error.message)
        }
    )
    return responseJson
}
export async function getNowFlow() {
    var responseJson = ''
    await axios.post('http://localhost:2333/nowFlow', '').then(
        (response) => {
            responseJson = response.data
        },
        (error) => {
            console.log('请求失败了', error.message)
        }
    )
    return responseJson
}
export async function getSitesFlow() {
    var responseJson = ''
    await axios.post('http://localhost:2333/sitesFlow', '').then(
        (response) => {
            responseJson = response.data
        },
        (error) => {
            console.log('请求失败了', error.message)
        }
    )
    return responseJson
}
export async function getSitesFlowById(siteId) {
    var responseJson = ''
    await axios.post('http://localhost:2333/sitesFlow', 'siteId=' + siteId).then(
        (response) => {
            responseJson = response.data
        },
        (error) => {
            console.log('请求失败了', error.message)
        }
    )
    return responseJson
}
export async function getSitesHealth() {
    var responseJson = ''
    await axios.post('http://localhost:2333/sitesHealth', '').then(
        (response) => {
            responseJson = response.data
        },
        (error) => {
            console.log('请求失败了', error.message)
        }
    )
    return responseJson
}
export async function getSitesHealthById(siteId) {
    var responseJson = ''
    await axios
        .post('http://localhost:2333/sitesHealth', 'siteId=' + siteId)
        .then(
            (response) => {
                responseJson = response.data
            },
            (error) => {
                console.log('请求失败了', error.message)
            }
        )
    return responseJson
}
export async function getSitesUserNumber() {
    var responseJson = ''
    await axios.post('http://localhost:2333/sitesUser', '').then(
        (response) => {
            responseJson = response.data
        },
        (error) => {
            console.log('请求失败了', error.message)
        }
    )
    return responseJson
}
export async function getSitesWlan() {
    var responseJson = ''
    await axios.post('http://localhost:2333/sitesWlan', '').then(
        (response) => {
            responseJson = response.data
        },
        (error) => {
            console.log('请求失败了', error.message)
        }
    )
    return responseJson
}