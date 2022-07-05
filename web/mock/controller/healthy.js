const data = [
  {
    siteId: 'pr94wzkr-5yft-8741-fnd7-7hkm89exh07x',
    Healthy: [100, 100, 93, 4532, 1.599],
  },
  {
    siteId: 'up70flfs-6rvt-8061-xrg9-7qbw02fab00x',
    Healthy: [91, 97, 100, 8110, 2.72],
  },
  {
    siteId: 'yn07lymf-8teq-7051-ffs5-9sev17slm53j',
    Healthy: [100, 92, 100, 5078, 1.589],
  },
  {
    siteId: 'rr57aeto-9eta-6070-cmk6-3qmf75aeo88e',
    Healthy: [100, 100, 100, 3371, 1.581],
  },
  {
    siteId: 'wl75wwja-3yid-0696-nzl7-8aml81kgf30c',
    Healthy: [100, 100, 100, 9817, 1.599],
  },
  {
    siteId: 'lw83bmlk-0mfo-4513-jqe4-4zpc23jeu89z',
    Healthy: [100, 100, 100, 8656, 1.59],
  },
]
// deviceHealth radioHealth siteHealth humanFlow reVisitedRate
module.exports = [
  {
    url: '/healthy/getList',
    type: 'post',
    response(config) {
      const { title } = config.body
      let mockList = data.filter((item) => {
        if (title && item.indexOf(title) < 0) return false
        return true
      })

      return {
        code: 200,
        msg: 'success',
        data: mockList,
      }
    },
  },
]
