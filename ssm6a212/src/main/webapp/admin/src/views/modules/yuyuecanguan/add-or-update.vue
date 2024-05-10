<template>
  <div class="addEdit-block">
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
	  :style="{backgroundColor:addEditForm.addEditBoxColor}"
    >
      <el-row>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="企业账号" prop="qiyezhanghao">
          <el-input v-model="ruleForm.qiyezhanghao" 
              placeholder="企业账号" clearable  :readonly="ro.qiyezhanghao"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="企业账号" prop="qiyezhanghao">
              <el-input v-model="ruleForm.qiyezhanghao" 
                placeholder="企业账号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'" label="编号" prop="bianhao">
            <el-input v-model="ruleForm.bianhao" 
                placeholder="编号" readonly></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" v-if="ruleForm.bianhao" label="编号" prop="bianhao">
              <el-input v-model="ruleForm.bianhao" 
                placeholder="编号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="场地名称" prop="changdimingcheng">
          <el-input v-model="ruleForm.changdimingcheng" 
              placeholder="场地名称" clearable  :readonly="ro.changdimingcheng"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="场地名称" prop="changdimingcheng">
              <el-input v-model="ruleForm.changdimingcheng" 
                placeholder="场地名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="24">  
        <el-form-item class="upload" v-if="type!='info' && !ro.changditupian" label="场地图片" prop="changditupian">
          <file-upload
          tip="点击上传场地图片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.changditupian?ruleForm.changditupian:''"
          @change="changditupianUploadChange"
          ></file-upload>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.changditupian" label="场地图片" prop="changditupian">
            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.changditupian.split(',')" :src="item" width="100" height="100">
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="姓名" prop="xingming">
          <el-input v-model="ruleForm.xingming" 
              placeholder="姓名" clearable  :readonly="ro.xingming"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="姓名" prop="xingming">
              <el-input v-model="ruleForm.xingming" 
                placeholder="姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="手机" prop="shouji">
          <el-input v-model="ruleForm.shouji" 
              placeholder="手机" clearable  :readonly="ro.shouji"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="手机" prop="shouji">
              <el-input v-model="ruleForm.shouji" 
                placeholder="手机" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="select" v-if="type!='info'"  label="代表身份" prop="daibiaoshenfen">
          <el-select v-model="ruleForm.daibiaoshenfen" placeholder="请选择代表身份">
            <el-option
                v-for="(item,index) in daibiaoshenfenOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="代表身份" prop="daibiaoshenfen">
	      <el-input v-model="ruleForm.daibiaoshenfen"
                placeholder="代表身份" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="公司名称" prop="gongsimingcheng">
          <el-input v-model="ruleForm.gongsimingcheng" 
              placeholder="公司名称" clearable  :readonly="ro.gongsimingcheng"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="公司名称" prop="gongsimingcheng">
              <el-input v-model="ruleForm.gongsimingcheng" 
                placeholder="公司名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="职务" prop="zhiwu">
          <el-input v-model="ruleForm.zhiwu" 
              placeholder="职务" clearable  :readonly="ro.zhiwu"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="职务" prop="zhiwu">
              <el-input v-model="ruleForm.zhiwu" 
                placeholder="职务" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="参观目的" prop="canguanmude">
          <el-input v-model="ruleForm.canguanmude" 
              placeholder="参观目的" clearable  :readonly="ro.canguanmude"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="参观目的" prop="canguanmude">
              <el-input v-model="ruleForm.canguanmude" 
                placeholder="参观目的" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="date" v-if="type!='info'" label="参观时间" prop="canguanshijian">
            <el-date-picker
                value-format="yyyy-MM-dd HH:mm:ss"
                v-model="ruleForm.canguanshijian" 
                type="datetime"
                placeholder="参观时间">
            </el-date-picker>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" v-if="ruleForm.canguanshijian" label="参观时间" prop="canguanshijian">
              <el-input v-model="ruleForm.canguanshijian" 
                placeholder="参观时间" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="公司现有员工数" prop="gongsixianyouyuangongshu">
          <el-input v-model="ruleForm.gongsixianyouyuangongshu" 
              placeholder="公司现有员工数" clearable  :readonly="ro.gongsixianyouyuangongshu"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="公司现有员工数" prop="gongsixianyouyuangongshu">
              <el-input v-model="ruleForm.gongsixianyouyuangongshu" 
                placeholder="公司现有员工数" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="所需工位数" prop="suoxugongweishu">
          <el-input v-model="ruleForm.suoxugongweishu" 
              placeholder="所需工位数" clearable  :readonly="ro.suoxugongweishu"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="所需工位数" prop="suoxugongweishu">
              <el-input v-model="ruleForm.suoxugongweishu" 
                placeholder="所需工位数" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="车辆信息" prop="cheliangxinxi">
          <el-input v-model="ruleForm.cheliangxinxi" 
              placeholder="车辆信息" clearable  :readonly="ro.cheliangxinxi"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="车辆信息" prop="cheliangxinxi">
              <el-input v-model="ruleForm.cheliangxinxi" 
                placeholder="车辆信息" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="其他人员" prop="qitarenyuan">
          <el-input v-model="ruleForm.qitarenyuan" 
              placeholder="其他人员" clearable  :readonly="ro.qitarenyuan"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="其他人员" prop="qitarenyuan">
              <el-input v-model="ruleForm.qitarenyuan" 
                placeholder="其他人员" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="手机号" prop="shoujihao">
          <el-input v-model="ruleForm.shoujihao" 
              placeholder="手机号" clearable  :readonly="ro.shoujihao"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="手机号" prop="shoujihao">
              <el-input v-model="ruleForm.shoujihao" 
                placeholder="手机号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="备注" prop="beizhu">
          <el-input v-model="ruleForm.beizhu" 
              placeholder="备注" clearable  :readonly="ro.beizhu"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="备注" prop="beizhu">
              <el-input v-model="ruleForm.beizhu" 
                placeholder="备注" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      </el-row>
      <el-form-item class="btn">
        <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
        <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
        <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
  data() {
    let self = this
    var validateIdCard = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("请输入正确的身份证号码"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isURL(value)) {
        callback(new Error("请输入正确的URL地址"));
      } else {
        callback();
      }
    };
    var validateMobile = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("请输入正确的手机号码"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isPhone(value)) {
        callback(new Error("请输入正确的电话号码"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("请输入正确的邮箱地址"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("请输入整数"));
      } else {
        callback();
      }
    };
    return {
	  addEditForm: {"btnSaveFontColor":"#fff","selectFontSize":"14px","btnCancelBorderColor":"#DCDFE6","inputBorderRadius":"4px","inputFontSize":"14px","textareaBgColor":"#fff","btnSaveFontSize":"14px","textareaBorderRadius":"4px","uploadBgColor":"#fff","textareaBorderStyle":"solid","btnCancelWidth":"88px","textareaHeight":"120px","dateBgColor":"#fff","btnSaveBorderRadius":"4px","uploadLableFontSize":"14px","textareaBorderWidth":"1px","inputLableColor":"#606266","addEditBoxColor":"#fff","dateIconFontSize":"14px","btnSaveBgColor":"rgba(36, 194, 205, 1)","uploadIconFontColor":"#8c939d","textareaBorderColor":"#DCDFE6","btnCancelBgColor":"#ecf5ff","selectLableColor":"#606266","btnSaveBorderStyle":"solid","dateBorderWidth":"1px","dateLableFontSize":"14px","dateBorderRadius":"4px","btnCancelBorderStyle":"solid","selectLableFontSize":"14px","selectBorderStyle":"solid","selectIconFontColor":"#C0C4CC","btnCancelHeight":"44px","inputHeight":"40px","btnCancelFontColor":"#606266","dateBorderColor":"#DCDFE6","dateIconFontColor":"#C0C4CC","uploadBorderStyle":"solid","dateBorderStyle":"solid","dateLableColor":"#606266","dateFontSize":"14px","inputBorderWidth":"1px","uploadIconFontSize":"28px","selectHeight":"40px","inputFontColor":"#606266","uploadHeight":"148px","textareaLableColor":"#606266","textareaLableFontSize":"14px","btnCancelFontSize":"14px","inputBorderStyle":"solid","btnCancelBorderRadius":"4px","inputBgColor":"#fff","inputLableFontSize":"14px","uploadLableColor":"#606266","uploadBorderRadius":"4px","btnSaveHeight":"44px","selectBgColor":"#fff","btnSaveWidth":"88px","selectIconFontSize":"14px","dateHeight":"40px","selectBorderColor":"#DCDFE6","inputBorderColor":"#DCDFE6","uploadBorderColor":"#DCDFE6","textareaFontColor":"#606266","selectBorderWidth":"1px","dateFontColor":"#606266","btnCancelBorderWidth":"1px","uploadBorderWidth":"1px","textareaFontSize":"14px","selectBorderRadius":"4px","selectFontColor":"#606266","btnSaveBorderColor":"#409EFF","btnSaveBorderWidth":"0px"},
      id: '',
      type: '',
      ro:{
	qiyezhanghao : false,
	bianhao : false,
	changdimingcheng : false,
	changditupian : false,
	xingming : false,
	shouji : false,
	daibiaoshenfen : false,
	gongsimingcheng : false,
	zhiwu : false,
	canguanmude : false,
	canguanshijian : false,
	gongsixianyouyuangongshu : false,
	suoxugongweishu : false,
	cheliangxinxi : false,
	qitarenyuan : false,
	shoujihao : false,
	beizhu : false,
	sfsh : false,
	shhf : false,
	userid : false,
      },
      ruleForm: {
        qiyezhanghao: '',
        bianhao: this.getUUID(),
        changdimingcheng: '',
        changditupian: '',
        xingming: '',
        shouji: '',
        daibiaoshenfen: '',
        gongsimingcheng: '',
        zhiwu: '',
        canguanmude: '',
        canguanshijian: '',
        gongsixianyouyuangongshu: '',
        suoxugongweishu: '',
        cheliangxinxi: '',
        qitarenyuan: '',
        shoujihao: '',
        beizhu: '',
        shhf: '',
        userid: '',
      },
          daibiaoshenfenOptions: [],
      rules: {
          qiyezhanghao: [
          ],
          bianhao: [
          ],
          changdimingcheng: [
          ],
          changditupian: [
          ],
          xingming: [
          ],
          shouji: [
                { validator: validateMobile, trigger: 'blur' },
          ],
          daibiaoshenfen: [
          ],
          gongsimingcheng: [
          ],
          zhiwu: [
          ],
          canguanmude: [
          ],
          canguanshijian: [
          ],
          gongsixianyouyuangongshu: [
          ],
          suoxugongweishu: [
          ],
          cheliangxinxi: [
          ],
          qitarenyuan: [
          ],
          shoujihao: [
                { validator: validateMobile, trigger: 'blur' },
          ],
          beizhu: [
          ],
          sfsh: [
          ],
          shhf: [
          ],
          userid: [
          ],
      }
    };
  },
  props: ["parent"],
  computed: {
  },
  created() {
	this.addEditStyleChange()
	this.addEditUploadStyleChange()
  },
  methods: {
    // 下载
    download(file){
      window.open(`${file}`)
    },
    // 初始化
    init(id,type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if(this.type=='info'||this.type=='else'){
        this.info(id);
      }else if(this.type=='cross'){
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj){
          if(o=='qiyezhanghao'){
            this.ruleForm.qiyezhanghao = obj[o];
	    this.ro.qiyezhanghao = true;
            continue;
          }
          if(o=='bianhao'){
            this.ruleForm.bianhao = obj[o];
	    this.ro.bianhao = true;
            continue;
          }
          if(o=='changdimingcheng'){
            this.ruleForm.changdimingcheng = obj[o];
	    this.ro.changdimingcheng = true;
            continue;
          }
          if(o=='changditupian'){
            this.ruleForm.changditupian = obj[o];
	    this.ro.changditupian = true;
            continue;
          }
          if(o=='xingming'){
            this.ruleForm.xingming = obj[o];
	    this.ro.xingming = true;
            continue;
          }
          if(o=='shouji'){
            this.ruleForm.shouji = obj[o];
	    this.ro.shouji = true;
            continue;
          }
          if(o=='daibiaoshenfen'){
            this.ruleForm.daibiaoshenfen = obj[o];
	    this.ro.daibiaoshenfen = true;
            continue;
          }
          if(o=='gongsimingcheng'){
            this.ruleForm.gongsimingcheng = obj[o];
	    this.ro.gongsimingcheng = true;
            continue;
          }
          if(o=='zhiwu'){
            this.ruleForm.zhiwu = obj[o];
	    this.ro.zhiwu = true;
            continue;
          }
          if(o=='canguanmude'){
            this.ruleForm.canguanmude = obj[o];
	    this.ro.canguanmude = true;
            continue;
          }
          if(o=='canguanshijian'){
            this.ruleForm.canguanshijian = obj[o];
	    this.ro.canguanshijian = true;
            continue;
          }
          if(o=='gongsixianyouyuangongshu'){
            this.ruleForm.gongsixianyouyuangongshu = obj[o];
	    this.ro.gongsixianyouyuangongshu = true;
            continue;
          }
          if(o=='suoxugongweishu'){
            this.ruleForm.suoxugongweishu = obj[o];
	    this.ro.suoxugongweishu = true;
            continue;
          }
          if(o=='cheliangxinxi'){
            this.ruleForm.cheliangxinxi = obj[o];
	    this.ro.cheliangxinxi = true;
            continue;
          }
          if(o=='qitarenyuan'){
            this.ruleForm.qitarenyuan = obj[o];
	    this.ro.qitarenyuan = true;
            continue;
          }
          if(o=='shoujihao'){
            this.ruleForm.shoujihao = obj[o];
	    this.ro.shoujihao = true;
            continue;
          }
          if(o=='beizhu'){
            this.ruleForm.beizhu = obj[o];
	    this.ro.beizhu = true;
            continue;
          }
          if(o=='userid'){
            this.ruleForm.userid = obj[o];
	    this.ro.userid = true;
            continue;
          }
        }
      }
      // 获取用户信息
      this.$http({
        url: `${this.$storage.get('sessionTable')}/session`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          var json = data.data;
		if(json.qiyezhanghao!=''&&json.qiyezhanghao){
              		this.ruleForm.qiyezhanghao = json.qiyezhanghao
		}
        } else {
          this.$message.error(data.msg);
        }
      });
            this.daibiaoshenfenOptions = "个人,公司".split(',')
    },
    // 多级联动参数
    info(id) {
      this.$http({
        url: `yuyuecanguan/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
	//解决前台上传图片后台不显示的问题
	let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },
    // 提交
    onSubmit() {
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}




















      this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `yuyuecanguan/${!this.ruleForm.id ? "save" : "update"}`,
            method: "post",
            data: this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.parent.showFlag = true;
                  this.parent.addOrUpdateFlag = false;
                  this.parent.yuyuecanguanCrossAddOrUpdateFlag = false;
                  this.parent.search();
                  this.parent.contentStyleChange();
                }
              });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.yuyuecanguanCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    changditupianUploadChange(fileUrls) {
	this.ruleForm.changditupian = fileUrls;
			this.addEditUploadStyleChange()
    },
	addEditStyleChange() {
	  this.$nextTick(()=>{
	    // input
	    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputFontColor
	      el.style.fontSize = this.addEditForm.inputFontSize
	      el.style.borderWidth = this.addEditForm.inputBorderWidth
	      el.style.borderStyle = this.addEditForm.inputBorderStyle
	      el.style.borderColor = this.addEditForm.inputBorderColor
	      el.style.borderRadius = this.addEditForm.inputBorderRadius
	      el.style.backgroundColor = this.addEditForm.inputBgColor
	    })
	    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputLableColor
	      el.style.fontSize = this.addEditForm.inputLableFontSize
	    })
	    // select
	    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectFontColor
	      el.style.fontSize = this.addEditForm.selectFontSize
	      el.style.borderWidth = this.addEditForm.selectBorderWidth
	      el.style.borderStyle = this.addEditForm.selectBorderStyle
	      el.style.borderColor = this.addEditForm.selectBorderColor
	      el.style.borderRadius = this.addEditForm.selectBorderRadius
	      el.style.backgroundColor = this.addEditForm.selectBgColor
	    })
	    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectLableColor
	      el.style.fontSize = this.addEditForm.selectLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
	      el.style.color = this.addEditForm.selectIconFontColor
	      el.style.fontSize = this.addEditForm.selectIconFontSize
	    })
	    // date
	    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateFontColor
	      el.style.fontSize = this.addEditForm.dateFontSize
	      el.style.borderWidth = this.addEditForm.dateBorderWidth
	      el.style.borderStyle = this.addEditForm.dateBorderStyle
	      el.style.borderColor = this.addEditForm.dateBorderColor
	      el.style.borderRadius = this.addEditForm.dateBorderRadius
	      el.style.backgroundColor = this.addEditForm.dateBgColor
	    })
	    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateLableColor
	      el.style.fontSize = this.addEditForm.dateLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
	      el.style.color = this.addEditForm.dateIconFontColor
	      el.style.fontSize = this.addEditForm.dateIconFontSize
	      el.style.lineHeight = this.addEditForm.dateHeight
	    })
	    // upload
	    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
	    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
	      el.style.width = this.addEditForm.uploadHeight
	      el.style.height = this.addEditForm.uploadHeight
	      el.style.borderWidth = this.addEditForm.uploadBorderWidth
	      el.style.borderStyle = this.addEditForm.uploadBorderStyle
	      el.style.borderColor = this.addEditForm.uploadBorderColor
	      el.style.borderRadius = this.addEditForm.uploadBorderRadius
	      el.style.backgroundColor = this.addEditForm.uploadBgColor
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.uploadHeight
	      el.style.color = this.addEditForm.uploadLableColor
	      el.style.fontSize = this.addEditForm.uploadLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
	      el.style.color = this.addEditForm.uploadIconFontColor
	      el.style.fontSize = this.addEditForm.uploadIconFontSize
	      el.style.lineHeight = iconLineHeight
	      el.style.display = 'block'
	    })
	    // 多文本输入框
	    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
	      el.style.height = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaFontColor
	      el.style.fontSize = this.addEditForm.textareaFontSize
	      el.style.borderWidth = this.addEditForm.textareaBorderWidth
	      el.style.borderStyle = this.addEditForm.textareaBorderStyle
	      el.style.borderColor = this.addEditForm.textareaBorderColor
	      el.style.borderRadius = this.addEditForm.textareaBorderRadius
	      el.style.backgroundColor = this.addEditForm.textareaBgColor
	    })
	    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
	      // el.style.lineHeight = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaLableColor
	      el.style.fontSize = this.addEditForm.textareaLableFontSize
	    })
	    // 保存
	    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
	      el.style.width = this.addEditForm.btnSaveWidth
	      el.style.height = this.addEditForm.btnSaveHeight
	      el.style.color = this.addEditForm.btnSaveFontColor
	      el.style.fontSize = this.addEditForm.btnSaveFontSize
	      el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
	      el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
	      el.style.borderColor = this.addEditForm.btnSaveBorderColor
	      el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnSaveBgColor
	    })
	    // 返回
	    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
	      el.style.width = this.addEditForm.btnCancelWidth
	      el.style.height = this.addEditForm.btnCancelHeight
	      el.style.color = this.addEditForm.btnCancelFontColor
	      el.style.fontSize = this.addEditForm.btnCancelFontSize
	      el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
	      el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
	      el.style.borderColor = this.addEditForm.btnCancelBorderColor
	      el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnCancelBgColor
	    })
	  })
	},
	addEditUploadStyleChange() {
		this.$nextTick(()=>{
		  document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
			el.style.width = this.addEditForm.uploadHeight
			el.style.height = this.addEditForm.uploadHeight
			el.style.borderWidth = this.addEditForm.uploadBorderWidth
			el.style.borderStyle = this.addEditForm.uploadBorderStyle
			el.style.borderColor = this.addEditForm.uploadBorderColor
			el.style.borderRadius = this.addEditForm.uploadBorderRadius
			el.style.backgroundColor = this.addEditForm.uploadBgColor
		  })
	  })
	},
  }
};
</script>
<style lang="scss">
.editor{
  height: 500px;
  
  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
}
.btn .el-button {
  padding: 0;
}
</style>
