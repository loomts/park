<template>
  <div>
    <baidu-map
      class="map"
      :center="{ lng: 121.6675, lat: 31.1488 }"
      :zoom="18"
      :scroll-wheel-zoom="true"
    >
      <!-- 热力图 -->
      <bml-heatmap
        :data="data"
        :max="100"
        :radius="20"
        :gradient="{
          0.5: 'rgb(0, 110, 255)',
          0.8: 'rgb(15, 255, 31)',
          0.9: 'rgb(225, 75, 0)',
        }"
      ></bml-heatmap>
      <!-- 热力图 -->
      <!-- 路线 -->
      <bm-polyline
        :path="polylinePath"
        stroke-color="blue"
        :stroke-opacity="0.5"
        :stroke-weight="4"
        :editing="false"
      ></bm-polyline>
      <bm-polyline
        :path="polylinePath1"
        stroke-color="blue"
        :stroke-opacity="0.5"
        :stroke-weight="4"
        :editing="false"
      ></bm-polyline>
      <bm-polyline
        :path="polylinePath2"
        stroke-color="blue"
        :stroke-opacity="0.5"
        :stroke-weight="4"
        :editing="false"
      ></bm-polyline>
      <bm-polyline
        :path="polylinePath3"
        stroke-color="blue"
        :stroke-opacity="0.5"
        :stroke-weight="4"
        :editing="false"
      ></bm-polyline>
      <bm-polyline
        :path="polylinePath4"
        stroke-color="blue"
        :stroke-opacity="0.5"
        :stroke-weight="4"
        :editing="false"
      ></bm-polyline>
      <bm-polyline
        :path="polylinePath5"
        stroke-color="blue"
        :stroke-opacity="0.5"
        :stroke-weight="4"
        :editing="false"
      ></bm-polyline>
      <!-- <bml-curve-line :points="arcPoints" :editing="true"></bml-curve-line> -->
      <bml-curve-line
        :points="arcPoints"
        :stroke-color="blue"
        :editing="false"
      ></bml-curve-line>
      <bml-curve-line
        :points="arcPoints1"
        :stroke-color="blue"
        :editing="false"
      ></bml-curve-line>
      <bml-curve-line
        :points="arcPoints2"
        :stroke-color="blue"
        :editing="false"
      ></bml-curve-line>
      <bml-curve-line
        :points="arcPoints3"
        :stroke-color="blue"
        :editing="false"
      ></bml-curve-line>
      <bml-heatmap :data="heartData" :max="300" :radius="60"></bml-heatmap>
      <bm-label
        content="A"
        :position="{ lng: 121.667027, lat: 31.148817 }"
        :label-style="{ color: 'red', fontSize: '24px' }"
        title="Hover me"
      />
      <bm-label
        content="B"
        :position="{ lng: 121.66629, lat: 31.148254 }"
        :label-style="{ color: 'red', fontSize: '24px' }"
        title="Hover me"
      />
      <bm-label
        content="C"
        :position="{ lng: 121.664107, lat: 31.148385 }"
        :label-style="{ color: 'red', fontSize: '24px' }"
        title="Hover me"
      />
      <bm-label
        content="D"
        :position="{ lng: 121.663703, lat: 31.147597 }"
        :label-style="{ color: 'red', fontSize: '24px' }"
        title="Hover me"
      />
      <bm-label
        content="E"
        :position="{ lng: 121.663818, lat: 31.149092 }"
        :label-style="{ color: 'red', fontSize: '24px' }"
        title="Hover me"
      />
      <bm-label
        content="F"
        :position="{ lng: 121.663036, lat: 31.14961 }"
        :label-style="{ color: 'red', fontSize: '24px' }"
        title="Hover me"
      />
      <bm-label
        content="G"
        :position="{ lng: 121.664114, lat: 31.150259 }"
        :label-style="{ color: 'red', fontSize: '24px' }"
        title="Hover me"
      />
      <bm-label
        content="H"
        :position="{ lng: 121.66486, lat: 31.151314 }"
        :label-style="{ color: 'red', fontSize: '24px' }"
        title="Hover me"
      />
      <bm-label
        content="I"
        :position="{ lng: 121.666225, lat: 31.150908 }"
        :label-style="{ color: 'red', fontSize: '24px' }"
        title="Hover me"
      />
      <bm-label
        content="J"
        :position="{ lng: 121.667941, lat: 31.150595 }"
        :label-style="{ color: 'red', fontSize: '24px' }"
        title="Hover me"
      />
      <bm-label
        content="K"
        :position="{ lng: 121.668111, lat: 31.15126 }"
        :label-style="{ color: 'red', fontSize: '24px' }"
        title="Hover me"
      />
      <bm-label
        content="L"
        :position="{ lng: 121.669454, lat: 31.15141 }"
        :label-style="{ color: 'red', fontSize: '24px' }"
        title="Hover me"
      />
      <bm-label
        content="M"
        :position="{ lng: 121.670231, lat: 31.150703 }"
        :label-style="{ color: 'red', fontSize: '24px' }"
        title="Hover me"
      />
      <bm-label
        content="N"
        :position="{ lng: 121.669486, lat: 31.149355 }"
        :label-style="{ color: 'red', fontSize: '24px' }"
        title="Hover me"
      />
      <bm-label
        content="O"
        :position="{ lng: 121.668511, lat: 31.149726 }"
        :label-style="{ color: 'red', fontSize: '24px' }"
        title="Hover me"
      />

      <bm-label
        content="P"
        :position="{ lng: 121.66795, lat: 31.149231 }"
        :label-style="{ color: 'red', fontSize: '24px' }"
        title="Hover me"
      />
      <bm-label
        content="Q"
        :position="{ lng: 121.667846, lat: 31.148123 }"
        :label-style="{ color: 'red', fontSize: '24px' }"
        title="Hover me"
      />
      <bm-label
        content="R"
        :position="{ lng: 121.66614, lat: 31.149652 }"
        :label-style="{ color: 'red', fontSize: '24px' }"
        title="Hover me"
      />
      <bm-label
        content="S"
        :position="{ lng: 121.669562, lat: 31.146555 }"
        :label-style="{ color: 'red', fontSize: '24px' }"
        title="Hover me"
      />

      <!-- 路线 -->
      <bm-marker
        :position="{ lng: 121.669562, lat: 31.146555 }"
        :dragging="true"
        animation="BMAP_ANIMATION_BOUNCE"
      >
        <bm-label
          content="入口"
          :label-style="{ color: 'black', fontSize: '24px' }"
          :offset="{ width: -35, height: 30 }"
        />
      </bm-marker>
      <bm-marker
        :position="{ lng: 121.663719, lat: 31.147644 }"
        :dragging="true"
        animation="BMAP_ANIMATION_BOUNCE"
      >
        <bm-label
          content="明日世界"
          :label-style="{ color: 'black', fontSize: '24px' }"
          :offset="{ width: -35, height: 30 }"
        />
      </bm-marker>
      <bm-marker
        :position="{ lng: 121.663231, lat: 31.149708 }"
        :dragging="true"
        animation="BMAP_ANIMATION_BOUNCE"
      >
        <bm-label
          content="迪士尼.皮克斯玩具总动员"
          :label-style="{ color: 'black', fontSize: '24px' }"
          :offset="{ width: -35, height: 30 }"
        />
      </bm-marker>
      <bm-marker
        :position="{ lng: 121.666337, lat: 31.150738 }"
        :dragging="true"
        animation="BMAP_ANIMATION_BOUNCE"
      >
        <bm-label
          content="梦幻世界"
          :label-style="{ color: 'black', fontSize: '24px' }"
          :offset="{ width: -35, height: 30 }"
        />
      </bm-marker>
      <bm-marker
        :position="{ lng: 121.669354, lat: 31.151372 }"
        :dragging="true"
        animation="BMAP_ANIMATION_BOUNCE"
      >
        <bm-label
          content="宝藏湾"
          :label-style="{ color: 'black', fontSize: '24px' }"
          :offset="{ width: -35, height: 30 }"
        />
      </bm-marker>
      <bm-marker
        :position="{ lng: 121.666965, lat: 31.148937 }"
        :dragging="true"
        animation="BMAP_ANIMATION_BOUNCE"
      >
        <bm-label
          content="奇想花园"
          :label-style="{ color: 'black', fontSize: '24px' }"
          :offset="{ width: -35, height: 30 }"
        />
      </bm-marker>
      <bm-marker
        :position="{ lng: 121.669473, lat: 31.14947 }"
        :dragging="true"
        animation="BMAP_ANIMATION_BOUNCE"
      >
        <bm-label
          content="探险岛"
          :label-style="{ color: 'black', fontSize: '24px' }"
          :offset="{ width: -35, height: 30 }"
        />
      </bm-marker>
      <!-- <bm-view class="map"></bm-view>
    <bm-walking
      start="迪士尼梦幻世界"
      end="迪士尼·皮克斯玩具总动员"
      :auto-viewport="true"
      location="上海"
    ></bm-walking> -->
    </baidu-map>
    <div>
      <el-col :span="20" style="margin: 30px">
        <div class="block">
          <el-timeline>
            <div slot="header">
              <span style="font-size: 20px; color: #909399">行程记录</span>
            </div>
            <el-timeline-item timestamp="入口处游玩路径推荐" placement="top">
              <el-card>
                <div>
                  <el-table :data="tableData" style="width: 100%">
                    <el-table-column
                      prop="begin"
                      label="起点"
                      align="center"
                    ></el-table-column>
                    <el-table-column
                      prop="end"
                      label="终点"
                      align="center"
                    ></el-table-column>
                    <el-table-column
                      prop="dist"
                      label="距离"
                      align="center"
                    ></el-table-column>
                    <el-table-column
                      prop="time"
                      label="耗时"
                      align="center"
                    ></el-table-column>
                    <el-table-column
                      prop="totDist"
                      label="总距离"
                      align="center"
                    ></el-table-column>
                    <el-table-column
                      prop="totTime"
                      label="总耗时"
                      align="center"
                    ></el-table-column>
                  </el-table>
                </div>
              </el-card>
            </el-timeline-item>
          </el-timeline>
        </div>
      </el-col>
    </div>
  </div>
</template>

<script>
  import { BmlHeatmap, BmlCurveLine } from 'vue-baidu-map'
  export default {
    components: {
      BmlHeatmap,
      BmlCurveLine,
    },
    data() {
      return {
        data: [
          // 热力图的点数据，lng：点的经度 lat: 点的纬度 count：点的热力程度
          /*明日世界*/
          { lng: 121.663733326, lat: 31.147599152, count: 95 },
          { lng: 121.663733121, lat: 31.147599645, count: 153 },
          { lng: 121.663733567, lat: 31.150699317, count: 79 },
          { lng: 121.663733429, lat: 31.151999403, count: 46 },
          { lng: 121.663733159, lat: 31.152399842, count: 25 },
          { lng: 121.663733753, lat: 31.147599295, count: 123 },

          /*皮克斯玩具总动员*/
          { lng: 121.661656582, lat: 31.150754782, count: 359 },
          { lng: 121.661957216, lat: 31.15105557, count: 76 },
          { lng: 121.661356544, lat: 31.150855497, count: 125 },
          { lng: 121.661957244, lat: 31.151056119, count: 64 },
          { lng: 121.66175663, lat: 31.15085624, count: 97 },
          { lng: 121.66155598, lat: 31.150954968, count: 16 },

          /*米奇大街*/
          { lng: 121.668693712, lat: 31.14785658, count: 125 },
          { lng: 121.668247885, lat: 31.14771721, count: 72 },
          { lng: 121.668854569, lat: 31.147867656, count: 89 },
          { lng: 121.668575888, lat: 31.14774487, count: 56 },
          { lng: 121.668106665, lat: 31.1478018, count: 259 },
          { lng: 121.668535314, lat: 31.14830085, count: 159 },

          /*探险岛*/
          { lng: 121.669658442, lat: 31.149800436, count: 179 },
          { lng: 121.669413934, lat: 31.149424209, count: 11 },
          { lng: 121.669652364, lat: 31.149516201, count: 162 },
          { lng: 121.669674506, lat: 31.149564706, count: 108 },
          { lng: 121.669683762, lat: 31.149840598, count: 36 },
          { lng: 121.669826189, lat: 31.149985596, count: 39 },

          /*奇幻城堡:121.666109,31.14975*/
          { lng: 121.666122847, lat: 31.14975845, count: 23 },
          { lng: 121.666052796, lat: 31.149337046, count: 88 },
          { lng: 121.666108466, lat: 31.149880201, count: 40 },
          { lng: 121.666231725, lat: 31.149795888, count: 69 },
          { lng: 121.666076518, lat: 31.149554186, count: 115 },
          { lng: 121.666113117, lat: 31.149523601, count: 54 },

          /*七个小矮人:121.666037,31.150971*/
          { lng: 121.666175292, lat: 31.151396576, count: 127 },
          { lng: 121.66693213, lat: 31.151871744, count: 34 },
          { lng: 121.666579303, lat: 31.151533951, count: 95 },
          { lng: 121.666286172, lat: 31.151882123, count: 71 },
          { lng: 121.666645955, lat: 31.151215866, count: 159 },
          { lng: 121.666803883, lat: 31.151368183, count: 29 },

          /*星愿湖:121.67202,31.146351*/
          { lng: 121.672486574, lat: 31.146389548, count: 7 },
          { lng: 121.67261379, lat: 31.146568303, count: 18 },
          { lng: 121.672928391, lat: 31.146976983, count: 22 },
          { lng: 121.672517952, lat: 31.14681583, count: 11 },
          { lng: 121.672727951, lat: 31.14680312, count: 60 },
          { lng: 121.672189408, lat: 31.146882452, count: 32 },

          /*迪士尼小镇&迪士尼大剧院:121.667528,31.146181*/
          { lng: 121.667951956, lat: 31.146173484, count: 5 },
          { lng: 121.667658641, lat: 31.146745885, count: 28 },
          { lng: 121.667456119, lat: 31.146307154, count: 53 },
          { lng: 121.66783258, lat: 31.146181411, count: 45 },
          { lng: 121.667384388, lat: 31.146994101, count: 38 },
          { lng: 121.667528134, lat: 31.146181926, count: 120 },
          { lng: 121.667486799, lat: 31.147925926, count: 150 },
          { lng: 121.667712509, lat: 31.146956516, count: 41 },
          { lng: 121.667882343, lat: 31.146248166, count: 17 },
          { lng: 121.66791612, lat: 31.146309289, count: 51 },
        ],
        polylinePath: [
          { lng: 121.667027, lat: 31.148817 },
          { lng: 121.66629, lat: 31.148254 },
          { lng: 121.664107, lat: 31.148385 },
          { lng: 121.663703, lat: 31.147597 },
          { lng: 121.664107, lat: 31.148385 },
          { lng: 121.663818, lat: 31.149092 },
          // { lng: 121.66331, lat: 31.149625 },
          // { lng: 121.664114, lat: 31.150259 },
        ],
        polylinePath1: [
          { lng: 121.66486, lat: 31.151314 },
          { lng: 121.666225, lat: 31.150908 },
          { lng: 121.667941, lat: 31.150595 },
          { lng: 121.668111, lat: 31.15126 },
          { lng: 121.669454, lat: 31.15141 },
          { lng: 121.670231, lat: 31.150703 },
          { lng: 121.669486, lat: 31.149355 },
          { lng: 121.668511, lat: 31.149726 },
          { lng: 121.66795, lat: 31.149231 },
          { lng: 121.667027, lat: 31.148817 },
        ],
        polylinePath2: [
          { lng: 121.664114, lat: 31.150259 },
          { lng: 121.663818, lat: 31.149092 },
        ],
        polylinePath3: [
          { lng: 121.66614, lat: 31.149652 },
          { lng: 121.667941, lat: 31.150595 },
        ],
        polylinePath4: [
          { lng: 121.668511, lat: 31.149726 },
          { lng: 121.667941, lat: 31.150595 },
        ],
        polylinePath5: [
          { lng: 121.669562, lat: 31.146555 },
          { lng: 121.667846, lat: 31.148123 },
        ],
        arcPoints: [
          { lng: 121.66629, lat: 31.148254 },
          { lng: 121.66614, lat: 31.149652 },
          { lng: 121.66795, lat: 31.149231 },
          { lng: 121.667846, lat: 31.148123 },
          { lng: 121.66629, lat: 31.148254 },
        ],
        arcPoints1: [
          { lng: 121.663818, lat: 31.149092 },
          { lng: 121.663036, lat: 31.14961 },
          { lng: 121.664114, lat: 31.150259 },
          { lng: 121.66486, lat: 31.151314 },
        ],
        arcPoints2: [
          { lng: 121.666225, lat: 31.150908 },
          { lng: 121.66614, lat: 31.149652 },
          { lng: 121.664114, lat: 31.150259 },
        ],
        arcPoints3: [
          { lng: 121.667846, lat: 31.148123 },
          { lng: 121.667027, lat: 31.148817 },
          { lng: 121.66614, lat: 31.149652 },
        ],
        tableData: [
          {
            begin: '上海迪士尼度假区东南门（S）',
            time: '4min',
            dist: '225m',
            end: '米奇大街(Q)',
          },
          {
            begin: '米奇大街Q',
            time: '3min',
            dist: '174m',
            end: '奇想花园左下路口(B)',
          },
          {
            begin: '奇想花园左下路口(B)',
            time: '3min',
            dist: '189m',
            end: '明日世界右上路口(C)',
          },
          {
            begin: '明日世界右上路口(C)',
            time: '2min',
            dist: '82m',
            end: '明日世界(D)',
          },
          {
            begin: '明日世界(D)',
            time: '2min',
            dist: '82m',
            end: '明日世界右上路口(C)',
          },
          {
            begin: '明日世界右上路口(C)',
            time: '2min',
            dist: '91m',
            end: '玩具总动员右下路口(E)',
          },
          {
            begin: '玩具总动员右下路口(E)',
            time: '2min',
            dist: '108m',
            end: '玩具总动员(F)',
          },
          {
            begin: '玩具总动员(F)',
            time: '2min',
            dist: '112m',
            end: '玩具总动员右上路口(G)',
          },
          {
            begin: '玩具总动员右上路口(G)',
            time: '3min',
            dist: '186m',
            end: '奇幻童话城堡(R)',
          },
          {
            begin: '奇幻童话城堡(R)',
            time: '2min',
            dist: '113m',
            end: '梦幻世界(I)',
          },
          {
            begin: '梦幻世界(I)',
            time: '3min',
            dist: '167m',
            end: '小卖部(J)',
          },
          {
            begin: '小卖部(J)',
            time: '1min',
            dist: '53m',
            end: '宝藏湾左边路口(K)',
          },
          {
            begin: '宝藏湾左边路口(K)',
            time: '2min',
            dist: '117m',
            end: '宝藏湾(J)',
          },
          {
            begin: '宝藏湾(J)',
            time: '2min',
            dist: '87m',
            end: '宝藏湾右边路口(M)',
          },
          {
            begin: '宝藏湾右边路口(M)',
            time: '3min',
            dist: '160m',
            end: '探险岛(N)',
          },
          {
            begin: '探险岛(N)',
            time: '2min',
            dist: '98m',
            end: '探险岛左边路口(O)',
          },
          {
            begin: '探险岛左边路口(O)',
            time: '2min',
            dist: '78m',
            end: '奇想花园右边路口(P)',
          },
          {
            begin: '奇想花园右边路口(P)',
            time: '2min',
            dist: '99m',
            end: '奇想花园(A)',
          },
          {
            totDist: '2221m',
            totTime: '42min',
          },
        ],
      }
    },
  }

  /**
   * 转换弧度
   * @param d
   * @returns {number}
   */
  function getRad(d) {
    var PI = Math.PI
    return (d * PI) / 180.0
  }

  /**
   * 根据经纬度计算两点间距离
   * @param lng1
   * @param lat1
   * @param lng2
   * @param lat2
   * @returns {number|*}
   * @constructor
   */
  function distance(lng1, lat1, lng2, lat2) {
    var f = getRad((lat1 + lat2) / 2)
    var g = getRad((lat1 - lat2) / 2)
    var l = getRad((lng1 - lng2) / 2)
    var sg = Math.sin(g)
    var sl = Math.sin(l)
    var sf = Math.sin(f)
    var s, c, w, r, d, h1, h2
    var a = 6378137.0 //The Radius of eath in meter.
    var fl = 1 / 298.257
    sg = sg * sg
    sl = sl * sl
    sf = sf * sf
    s = sg * (1 - sl) + (1 - sf) * sl
    c = (1 - sg) * (1 - sl) + sf * sl
    w = Math.atan(Math.sqrt(s / c))
    r = Math.sqrt(s * c) / w
    d = 2 * w * a
    h1 = (3 * r - 1) / 2 / c
    h2 = (3 * r + 1) / 2 / s
    s = d * (1 + fl * (h1 * sf * (1 - sg) - h2 * (1 - sf) * sg))
    if (s >= 1000 && s <= 99000) {
      var kilometer = s / 1000
      s = kilometer.toFixed(1) + 'km'
    } else if (s > 99000) {
      s = '>99km'
    } else {
      s = Math.round(s) + 'm'
    }
    // s = s/1000;
    // s = s.toFixed(2);//指定小数点后的位数。
    return s
  }
</script>
<style>
  .map {
    width: auto;
    height: 800px;
  }
</style>
