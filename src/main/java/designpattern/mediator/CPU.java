package designpattern.mediator;

/**
 * @author weigs
 * @date 2018/6/17 0017
 */
public class CPU extends Colleague {
    public CPU(Mediator mediator) {
        super(mediator);
    }

    //分解出来的视频数据
    private String videoData = "";

    //分解出来的音频数据
    private String soundData = "";

    public void executeData(String data) {
        String[] strs = data.split(",");
        this.videoData = strs[0];
        this.soundData = strs[1];
        //通知主板，CPU工作完成
        this.getMediator().change(this);
    }


    public String getVideoData() {
        return videoData;
    }

    public String getSoundData() {
        return soundData;
    }
}
