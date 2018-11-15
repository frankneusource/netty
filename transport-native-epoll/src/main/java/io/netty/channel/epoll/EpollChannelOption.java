/*
 * Copyright 2014 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty.channel.epoll;

import io.netty.channel.ChannelOption;
import io.netty.channel.unix.UnixChannelOption;
import java.net.InetAddress;
import java.util.Map;

public final class EpollChannelOption<T> extends UnixChannelOption<T> {
	//禁用NAGLE算法，等待数据达到包传输数据大小上限时发送
    public static final ChannelOption<Boolean> TCP_CORK = valueOf(EpollChannelOption.class, "TCP_CORK");
    //控制内核缓冲数据，以及缓冲数据的大小
    public static final ChannelOption<Long> TCP_NOTSENT_LOWAT = valueOf(EpollChannelOption.class, "TCP_NOTSENT_LOWAT");
    //表示如果一个连接上一段时间后没有任何数据发送，则设置了这个选项的本端向对端发送keepalive保活报文，设置连接上如果没有数据发送的话，多久后发送keepalive探测分组，单位是秒
    public static final ChannelOption<Integer> TCP_KEEPIDLE = valueOf(EpollChannelOption.class, "TCP_KEEPIDLE");
    //前后两次探测之间的时间间隔，单位是秒
    public static final ChannelOption<Integer> TCP_KEEPINTVL = valueOf(EpollChannelOption.class, "TCP_KEEPINTVL");
    //关闭一个非活跃连接之前的最大重试次数
    public static final ChannelOption<Integer> TCP_KEEPCNT = valueOf(EpollChannelOption.class, "TCP_KEEPCNT");
    //让tcp不用等到15次重试完成，就断开链接的超时时间
    public static final ChannelOption<Integer> TCP_USER_TIMEOUT =
            valueOf(EpollChannelOption.class, "TCP_USER_TIMEOUT");
    //允许绑定不存在的IP端口
    public static final ChannelOption<Boolean> IP_FREEBIND = valueOf("IP_FREEBIND");
	//其含义就是可以使一个服务器程序侦听所有的IP地址，哪怕不是本机的IP地址
    public static final ChannelOption<Boolean> IP_TRANSPARENT = valueOf("IP_TRANSPARENT");
	//系统内核返回数据的源IP地址
    public static final ChannelOption<Boolean> IP_RECVORIGDSTADDR = valueOf("IP_RECVORIGDSTADDR");
    //一次握手，HTTP/HTTPS时候极大减轻网络代价
    public static final ChannelOption<Integer> TCP_FASTOPEN = valueOf(EpollChannelOption.class, "TCP_FASTOPEN");
    public static final ChannelOption<Boolean> TCP_FASTOPEN_CONNECT =
            valueOf(EpollChannelOption.class, "TCP_FASTOPEN_CONNECT");
    //在 accept 的 socket 上面，只有当实际收到了数据，才唤醒正在 accept 的进程，可以减少一些无聊的上下文切换
    public static final ChannelOption<Integer> TCP_DEFER_ACCEPT =
            ChannelOption.valueOf(EpollChannelOption.class, "TCP_DEFER_ACCEPT");
    //关闭延迟确认机制
    public static final ChannelOption<Boolean> TCP_QUICKACK = valueOf(EpollChannelOption.class, "TCP_QUICKACK");
    //开启busy-pool，提升性能
    public static final ChannelOption<Integer> SO_BUSY_POLL = valueOf(EpollChannelOption.class, "SO_BUSY_POLL");
	//epoll选项，配置边缘触发还是条件触发
    public static final ChannelOption<EpollMode> EPOLL_MODE =
            ChannelOption.valueOf(EpollChannelOption.class, "EPOLL_MODE");

    public static final ChannelOption<Map<InetAddress, byte[]>> TCP_MD5SIG = valueOf("TCP_MD5SIG");

    @SuppressWarnings({ "unused", "deprecation" })
    private EpollChannelOption() {
    }
}
