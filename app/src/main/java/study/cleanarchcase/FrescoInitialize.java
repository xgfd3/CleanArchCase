package study.cleanarchcase;

import android.content.Context;
import android.os.Environment;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.util.ByteConstants;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

/**
 * Created by xucz on 2016/4/12.
 */
public class FrescoInitialize {
  public static final String IMAGE_PIPELINE_CACHE_DIR = "/fresco_image";//默认图所放路径的文件夹名
  public static final int MAX_DISK_CACHE_VERYLOW_SIZE = 10 * ByteConstants.MB;//默认图极低磁盘空间缓存的最大值
  public static final int MAX_DISK_CACHE_LOW_SIZE = 30 * ByteConstants.MB;//默认图低磁盘空间缓存的最大值
  public static final int MAX_DISK_CACHE_SIZE = 50 * ByteConstants.MB;//默认图磁盘缓存的最大值

  public static void init(Context context) {

    //内存配置
    //final MemoryCacheParams bitmapCacheParams = new MemoryCacheParams(
    //    FrescoConfig.MAX_MEMORY_CACHE_SIZE, // 内存缓存中总图片的最大大小,以字节为单位。
    //    Integer.MAX_VALUE,                     // 内存缓存中图片的最大数量。
    //    FrescoConfig.MAX_MEMORY_CACHE_SIZE, // 内存缓存中准备清除但尚未被删除的总图片的最大大小,以字节为单位。
    //    Integer.MAX_VALUE,                     // 内存缓存中准备清除的总图片的最大数量。
    //    Integer.MAX_VALUE);                    // 内存缓存中单个图片的最大大小。

    //修改内存图片缓存数量，空间策略（这个方式有点恶心）
    //Supplier<MemoryCacheParams> mSupplierMemoryCacheParams = new Supplier<MemoryCacheParams>() {
    //  @Override
    //  public MemoryCacheParams get() {
    //    return bitmapCacheParams;
    //  }
    //};

    //默认图片的磁盘配置
    DiskCacheConfig diskCacheConfig = DiskCacheConfig.newBuilder(context)
        .setBaseDirectoryPath(Environment.getExternalStorageDirectory().getAbsoluteFile())//缓存图片基路径
        .setBaseDirectoryName(IMAGE_PIPELINE_CACHE_DIR)//文件夹名
        // .setCacheErrorLogger(cacheErrorLogger)//日志记录器用于日志错误的缓存。
        // .setCacheEventListener(cacheEventListener)//缓存事件侦听器。
        // .setDiskTrimmableRegistry(diskTrimmableRegistry)//类将包含一个注册表的缓存减少磁盘空间的环境。
        //.setMaxCacheSize(FrescoConfig.MAX_DISK_CACHE_SIZE)//默认缓存的最大大小。
        .setMaxCacheSizeOnLowDiskSpace(MAX_DISK_CACHE_LOW_SIZE)//缓存的最大大小,使用设备时低磁盘空间。
        .setMaxCacheSizeOnVeryLowDiskSpace(MAX_DISK_CACHE_VERYLOW_SIZE)//缓存的最大大小,当设备极低磁盘空间
        // .setVersion(version)
        .build();

    ImagePipelineConfig imagerPipelineConfig =
        ImagePipelineConfig.newBuilder(context)
            //.setBitmapMemoryCacheParamsSupplier(mSupplierMemoryCacheParams)//内存缓存配置（一级缓存，已解码的图片）
            .setMainDiskCacheConfig(diskCacheConfig)//磁盘缓存配置（总，三级缓存）
            //.setSmallImageDiskCacheConfig(diskSmallCacheConfig)//磁盘缓存配置（小图片，可选～三级缓存的小图优化缓存）
            .build();

    Fresco.initialize(context, imagerPipelineConfig);
  }
}
