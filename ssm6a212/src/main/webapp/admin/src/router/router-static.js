import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import adminexam from '@/views/modules/exampaperlist/exam'
    import yuyuecanguan from '@/views/modules/yuyuecanguan/list'
    import examquestion from '@/views/modules/examquestion/list'
    import huodongxinxi from '@/views/modules/huodongxinxi/list'
    import changdixinxi from '@/views/modules/changdixinxi/list'
    import discusshuodongxinxi from '@/views/modules/discusshuodongxinxi/list'
    import storeup from '@/views/modules/storeup/list'
    import exampaper from '@/views/modules/exampaper/list'
    import discusschangdixinxi from '@/views/modules/discusschangdixinxi/list'
    import qiye from '@/views/modules/qiye/list'
    import changdileixing from '@/views/modules/changdileixing/list'
    import baomingxinxi from '@/views/modules/baomingxinxi/list'
    import yonghu from '@/views/modules/yonghu/list'
    import exampaperlist from '@/views/modules/exampaperlist/list'
    import config from '@/views/modules/config/list'
    import examrecord from '@/views/modules/examrecord/list'
    import changdiyuyue from '@/views/modules/changdiyuyue/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/yuyuecanguan',
        name: '预约参观',
        component: yuyuecanguan
      }
      ,{
	path: '/examquestion',
        name: '试题管理',
        component: examquestion
      }
      ,{
	path: '/huodongxinxi',
        name: '活动信息',
        component: huodongxinxi
      }
      ,{
	path: '/changdixinxi',
        name: '场地信息',
        component: changdixinxi
      }
      ,{
	path: '/discusshuodongxinxi',
        name: '活动信息评论',
        component: discusshuodongxinxi
      }
      ,{
	path: '/storeup',
        name: '我的收藏管理',
        component: storeup
      }
      ,{
	path: '/exampaper',
        name: '试卷管理',
        component: exampaper
      }
      ,{
	path: '/discusschangdixinxi',
        name: '场地信息评论',
        component: discusschangdixinxi
      }
      ,{
	path: '/qiye',
        name: '企业',
        component: qiye
      }
      ,{
	path: '/changdileixing',
        name: '场地类型',
        component: changdileixing
      }
      ,{
	path: '/baomingxinxi',
        name: '报名信息',
        component: baomingxinxi
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/exampaperlist',
        name: '试卷列表',
        component: exampaperlist
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/examrecord',
        name: '考试记录',
        component: examrecord
      }
      ,{
	path: '/changdiyuyue',
        name: '场地预约',
        component: changdiyuyue
      }
    ]
  },
  {
    path: '/adminexam',
    name: 'adminexam',
    component: adminexam,
    meta: {icon:'', title:'adminexam'}
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
