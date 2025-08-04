<template>
  <div class="layout-container">
    <div class="layout-header">
      <Header />
    </div>
    <div class="layout-main">
      <NuxtPage />
    </div>
    <div class="layout-footer">
      <Footer />
    </div>
  </div>
</template>
<script setup>

onMounted(()=>{
  document.body.style.margin='0';
});
</script>

<style lang="scss" scoped>

.layout-container {
  position: relative;
  width: 100%;
  height: 100%;
  .layout-main {
    width: 100%;
    /* height: 100%; */
    padding: 0;
  }
}
</style>
