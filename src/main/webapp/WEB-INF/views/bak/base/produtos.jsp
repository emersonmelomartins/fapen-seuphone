<section id="produtos" class="produtos">
<div class="container">
<h1 class="titulo">Produtos</h1>

<div class="produtos-lista">
<!-- Slider main container -->
  <!-- Swiper -->
  <div class="swiper-container">
    <div class="swiper-wrapper">
      <div class="swiper-slide"><img src="img/prod-01.png" alt=""></div>
      <div class="swiper-slide"><img src="img/prod-02.png" alt=""></div>
      <div class="swiper-slide"><img src="img/prod-03.png" alt=""></div>
      <div class="swiper-slide"><img src="img/prod-04.png" alt=""></div>
      <div class="swiper-slide"><img src="img/prod-05.png" alt=""></div>
      <div class="swiper-slide"><img src="img/prod-01.png" alt=""></div>
      <div class="swiper-slide"><img src="img/prod-02.png" alt=""></div>
      <div class="swiper-slide"><img src="img/prod-03.png" alt=""></div>
    </div>
    <div class="swiper-button-prev"></div>
    <div class="swiper-button-next"></div>
  </div>
  <button class="btn">Produtos</button>
</div>
</div>
</div>
<script>
    var swiper = new Swiper('.swiper-container', {
      slidesPerView: 4,
      spaceBetween: 30,
      centeredSlides: true,
      pagination: {
        el: '.swiper-pagination',
        clickable: true,
      },
      navigation: {
      nextEl: '.swiper-button-next',
      prevEl: '.swiper-button-prev',
    },
    autoplay: {
    delay: 3000,
  },
    });
  </script>

</section>