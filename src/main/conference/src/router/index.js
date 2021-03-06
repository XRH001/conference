import Vue from 'vue'
import VueRouter from 'vue-router'
import index from '../views/index'
const detail=() =>import('../views/detail');
const personalInfo=() => import('../views/personalInfo' ); // personalInfo from
const create=() => import('../views/create');
const login= ()=>import('../views/login');
const About= () => import('../views/About.vue');
const Register= () => import('../views/Register');
Vue.use(VueRouter);

const routes = [
  {
    path:'',
    redirect:'/index'
  },
  {
    path: '/index',
    name: 'index',
    component: index
  },{
    path:'/detail',
    name:'detail',
    component:detail
  },{
    path:'/create',
    name:'create',
    component:create
  },{
    path:'/personalInfo',
    name:'personalInfo',
    component:personalInfo
  },
  {
    path: '/About',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: About
  },
  {
    path:'/login',
    name:'login',
    component:login
  },
  {
    path:'/Register',
    name:'Register',
    component:Register
  }
];

const router = new VueRouter({
  routes,
  mode:'history'
});

export default router

