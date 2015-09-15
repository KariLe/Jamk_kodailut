<?php

class WikiController extends BaseController {

    public function __construct(WikipageRepository $pages)
    {
        $this->pages = $pages;
    }

    public function showPage($page)
    {
        $page = $this->pages->getPage($page);

        return View::make('wiki', array('page' => $page));
    }
}
?>
