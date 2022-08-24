<template>
<div id="app">
  <div class="player-container">
    
  </div>
  <div id="part1">
        <vue-core-video-player :src="require('@/assets/video/test3.mp4')" 
    :muted="true" 
    :loop="true" 
    :autoplay="true"
    preload="nona"
    controls="auto"  
    >
    </vue-core-video-player>
  </div>
<div id="part2">
    <vue-core-video-player :src="require('@/assets/video/test4.mp4')" 
    class = "video1"
    :muted="true" 
    :loop="true" 
    :autoplay="true"
    preload="nona"
    controls="auto"  
    >
    </vue-core-video-player>
</div>
<div id="part3">
    <vue-core-video-player :src="require('@/assets/video/test3.mp4')" 
    class = "video2"
    :muted="true" 
    :loop="true" 
    :autoplay="true"
    preload="nona"
    controls="auto"  
    >
    </vue-core-video-player>
</div>
 
<div id="part4">
    <vue-core-video-player :src="require('@/assets/video/test4.mp4')" 
    class = "video1"
    :muted="true" 
    :loop="true" 
    :autoplay="true"
    preload="nona"
    controls="auto"  
    >
    </vue-core-video-player>
</div>

</div>


</template>

<script>

    export default {
        name: 'VideoPlay',
        components: {},
        data() {
            return {      
            }
        },
            mounted() {},
        computed: {

        },
        methods: {
           
        }
    }
</script>

<style>
#part1{
width: 50%;
height: 50%;
 
float: left;
}
 
#part2{
width: 50%;
height: 50%;
 
float: left;
}
 
#part3{      /* div 换行 */
width: 50%;
height: 50%;
/* background: yellow; */
 
float: left;
clear: left;
}
 
#part4{
width: 50%;
height: 50%;
/* background: green; */
 
float: left;
}
 
</style>