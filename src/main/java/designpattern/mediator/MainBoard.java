package designpattern.mediator;

/**
 * @author weigs
 * @date 2018/6/17 0017
 */
public class MainBoard implements Mediator {
    private CDDriver cdDriver;

    private CPU cpu;

    private VideoCard videoCard;

    private SoundCard soundCard;


    public void setCdDriver(CDDriver cdDriver) {
        this.cdDriver = cdDriver;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public void setVideoCard(VideoCard videoCard) {
        this.videoCard = videoCard;
    }

    public void setSoundCard(SoundCard soundCard) {
        this.soundCard = soundCard;
    }

    @Override
    public void change(Colleague colleague) {
        if (colleague == cdDriver) {
            openCDDriverReadData((CDDriver) colleague);
        } else if (colleague == cpu) {
            openCPU((CPU) colleague);
        }
    }

    private void openCDDriverReadData(CDDriver cdDriver) {
        String data = cdDriver.getData();
        this.cpu.executeData(data);
    }

    private void openCPU(CPU cpu) {
        String videoData = cpu.getVideoData();
        String soundData = cpu.getSoundData();

        //数据传递给显卡和声卡显示出来
        videoCard.showData(videoData);
        soundCard.showData(soundData);
    }
}
