$(document).ready(function () {
    $('.carousel-inner').slick({
        dots: true,
        infinite: true,
        speed: 500,
        fade: true,
        cssEase: 'linear',
        autoplay: true,
        autoplaySpeed: 2000,
        prevArrow: "<button class=\"carousel-control-prev\" type=\"button\" data-bs-target=\"#carouselExampleCaptions\" data-bs-slide=\"prev\">" +
            "<div class=\"next-prev\">" +
            "<span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>" +
            "</div>" +
            "<span class=\"visually-hidden\">Previous</span>" +
            "</button>",
        nextArrow: "<button class=\"carousel-control-next\" type=\"button\" data-bs-target=\"#carouselExampleCaptions\" data-bs-slide=\"next\">" +
            "<div class=\"next-prev\">" +
            "<span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>" +
            "</div>" +
            "<span class=\"visually-hidden\">Previous</span>" +
            "</button>",
    });
    $('.slick-card').slick({
        slidesToShow: 4,
        slidesToScroll: 4,
        autoplay: true,
        autoplaySpeed: 2000,
        prevArrow: "<button class=\"carousel-control-prev\" type=\"button\" data-bs-target=\"#carouselExampleCaptions\" data-bs-slide=\"prev\">" +
            "<div class=\"next-prev\">" +
            "<span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>" +
            "</div>" +
            "<span class=\"visually-hidden\">Previous</span>" +
            "</button>",
        nextArrow: "<button class=\"carousel-control-next\" type=\"button\" data-bs-target=\"#carouselExampleCaptions\" data-bs-slide=\"next\">" +
            "<div class=\"next-prev\">" +
            "<span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>" +
            "</div>" +
            "<span class=\"visually-hidden\">Previous</span>" +
            "</button>",
    });
    $('.sclick-evaluate').slick({
        slidesToShow: 2,
        slidesToScroll: 2,
        autoplay: true,
        autoplaySpeed: 20000000,
        prevArrow: "<button class=\"carousel-control-prev carousel-control-prev2\" type=\"button\" data-bs-target=\"#carouselExampleCaptions\" data-bs-slide=\"prev\">" +
            "<div class=\"next-prev\">" +
            "<span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>" +
            "</div>" +
            "<span class=\"visually-hidden\">Previous</span>" +
            "</button>",
        nextArrow: "<button class=\"carousel-control-next carousel-control-next2\" type=\"button\" data-bs-target=\"#carouselExampleCaptions\" data-bs-slide=\"next\">" +
            "<div class=\"next-prev\">" +
            "<span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>" +
            "</div>" +
            "<span class=\"visually-hidden\">Previous</span>" +
            "</button>",
    });
});