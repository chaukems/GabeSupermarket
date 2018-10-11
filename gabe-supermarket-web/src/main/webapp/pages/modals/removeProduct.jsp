<div class="modal-header">
    <h3 class="modal-title" id="modal-title">Remove Product</h3>
</div>
<div class="modal-body" id="modal-body">
    <div class="right_col" role="main">
        <div class="">         
            <div class="clearfix"></div>
            <div class="row" ng-show="$removePCtrl.productRemoved">
                <div class="isa_error">
                    <i class="fa fa-times-circle"></i>
                    <span>Product removed, please close and continue shopping!</span>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">                       
                        <div class="x_content">
                            <br/>
                            <form id="referralForm" class="form-horizontal form-label-left">                             

                                <div class="form-group">
                                    <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Bar code</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" ng-model="$removePCtrl.productBarCode" class="form-control col-md-7 col-xs-12" style="height:80px"/>                                       
                                    </div>
                                </div> 
                            </form>
                        </div>
                    </div>
                </div>
            </div>            
        </div>
        <div class="modal-footer">
            <button class="btn btn-primary" type="button" ng-click="$ctrl.ok(referralBean)">Remove</button>
            <button class="btn btn-warning" type="button" ng-click="$ctrl.cancel()">Close</button>
        </div>