<template>
    <div>
        <div class="form-group">
            <label class="col-label col-sm-2">車牌編號</label>
            <div class="col-sm-2"><span v-text="vehicle.plateNo"></span></div>
            <label class="col-label col-sm-2">首次登記日期</label>
            <div class="col-sm-2"><span v-text="vehicle.vehRegDate"></span></div>
            <label class="col-label col-sm-2">狀態</label>
            <div class="col-sm-2"><span v-text="vehicle.status"></span>
            </div>
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
        var vehicleDetail = Vue.extend({
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
                    vehicle: {

                    }
                }
            },
            methods:{
                initData:function(){

                },
                loadData:function(){
                    var self = this;
                    if(self.value){
                        self.vehicle = self.value;
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
        Vue.component('vehicle-detail', vehicleDetail);
    });

</script>