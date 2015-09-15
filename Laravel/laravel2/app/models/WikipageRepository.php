<?php

use \Michelf\Markdown;

class WikipageRepository {

    protected $datapath;

    public function __construct()
    {
        $this->datapath = base_path() . '/wiki';
    }

    public function setDatapath($newpath)
    {
        $this->datapath = $newpath;
    }

    public function getPage($page)
    {
        $pagehtml = '<h2>' . $page . ' not found!</h2>';

        $path = $this->datapath . '/' . $page . '.md';
        if (file_exists($path)) {

            $pagehtml = Markdown::defaultTransform(file_get_contents($path));

        }

        $page = new Wikipage($page, $pagehtml);
        return $page;
    }
}
?>
