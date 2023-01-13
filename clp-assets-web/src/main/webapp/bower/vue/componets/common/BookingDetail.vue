<template>
    <div>
        <div class="form-group">
            <label class="col-label col-sm-2">籌仔編號</label>
            <div class="col-sm-2"><span v-text="booking.jettonNo"></span></div>
            <label class="col-label col-sm-2">籌仔類型</label>
            <div class="col-sm-2"><span v-text="booking.jettonType"></span></div>
            <label class="col-label col-sm-2">服務地點</label>
            <div class="col-sm-2"><span v-text="booking.centerCode"></span></div>
        </div>

        <div class="form-group">
            <label class="col-label col-sm-2">預約時間</label>
            <div class="col-sm-6"><span v-text="booking.jettonBeginDate"></span> ~ <span v-text="booking.jettonEndDate"></span></div>
            <label class="col-label col-sm-2">預約電話</label>
            <div class="col-sm-2"><span v-text="booking.status"></span></div>
        </div>

        <div class="form-group">
            <label class="col-label col-sm-2">預約電話</label>
            <div class="col-sm-2"><span v-text="booking.jettonPhone"></span></div>
        </div>
    </div>
</template>

<script>
    define(['jquery',
        'atosBaseController',
        'moment.config',
        'axios',
        'atosUtil',
        'Vue',
        'datatables',
        'fancybox',
        'jquery.config',
        'axios.config',
        'datatables.config',
        'fancybox.config',
        'datetimepicker.config',
        'vueSelect2',
        'bootstrapValidator.config',
        'select2',
        'select2.config',
        'bootstrap-dialog'
    ],function($, atosBaseController, momentConfig, axios, atosUtil, Vue){
        var bookingDetail = Vue.extend({
            template:template,
            props: {
                show: {
                    type: Boolean,
                    default: false
                },
                value:{type:Object},
            },
            created:function(){
                this.initData();
            },
            data:function(){
                return {
                    booking: {

                    }
                }
            },
            methods:{
                initData:function(){

                },
                loadData:function(){
                    var self = this;
                    if(self.value){
                        self.booking = self.value;
                    }
                }
            },
            watch:{
                value:function(val){
                    if (val){
                        this.loadData();
                    }
                }
            },
            mounted: function () {
                this.loadData();
            }
        })
        Vue.component('booking-detail', bookingDetail);
    });

</script>