const data = [{
    title: '门票滞销，帮帮我们',
    url: 'https://www.disney.cn/',
}, ]
module.exports = [{
    url: '/ad/getList',
    type: 'get',
    response() {
        return {
            code: 200,
            msg: 'success',
            data,
        }
    },
}, ]