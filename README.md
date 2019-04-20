# threadhandler


![image](https://github.com/jw20082009/threadhandler/tree/master/images/output.gif)

> 消息循环队列是应用很广的一种线程模型，在linux系统中也被广泛应用来提高事件处理效率，而android提供的handler机制是对这一机制的一种非常棒的封装，让我们可以在写很少代码的情况下就能实现这套流程。我这个库提供了android handler机制的补充，分别提供了ui线程与后台线程的两个handler，可以基本满足日常使用中对于后台线程的使用要求，而且提供了一种防止handler内存泄露的机制，以及一种方便易用的基于页面后台循环线程模型，配合uihandler使用简直爽到飞起

## 主要特性
* 封装了ThreadHandler(HandlerThread Looper)以及UIHandler(MainLooper)，分别提供了销毁的onDestroy方法

* 基于ThreadHandler以及UIHandler提供了一个示范用的BaseThreadHandlerActivity和BaseUIHandlerActivity

* 将所有handler放在一个HandlerManager中统一管理

* BaseThreadHandlerActivity extends BaseUIHandlerActivity 提供了一个后台线程的handler，可以用来做一些页面上需要频繁处理的耗时操作，例如：后台图片加载、本地io操作、数据库操作
## 使用方法
> 可参考两个示例activity
* 提供UIHandlerWorker和ThreadHandlerWorker用于接收handler回调
* new出所需要的Handler并将相应的回调传入
* 在适当的时候onDestroy

