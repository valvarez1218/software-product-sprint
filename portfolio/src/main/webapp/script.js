// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomFact() {
  const facts =
      ['Born December 18, 2000', 'Youngest of three!', 'Likes to watch anime!', 'Black belt in Karate!'];

  // Pick a random fact.
  const fact = facts[Math.floor(Math.random() * facts.length)];

  // Add it to the page.
  const factContainer = document.getElementById('fact-container');
  factContainer.innerText = fact;
}

async function getArtist() {
    const responseFromServer = await fetch('/artist');
    const textResponse = await responseFromServer.json();

    console.log(textResponse.selectedArtist);

    const artistContainer = document.getElementById('artist-container');
    artistContainer.innerText = textResponse.selectedArtist;
}

function loadComments() {
  fetch('/view-comments').then(response => response.json()).then((comments) => {
    const commentElementList = document.getElementById('comment-list');
    comments.forEach((comment) => {
      console.log(comment.message);
      commentElementList.appendChild(createCommentElement(comment));
    })
  });
}

function createCommentElement (comment) {
    const commentElement = document.createElement('div');
    commentElement.className = "card";

    const title = document.createElement('h5');
    title.className = "card-title";
    title.innerText = comment.title;

    const content = document.createElement('p');
    content.className = "card-text";
    content.innerText = comment.message;

    commentElement.appendChild(title);
    commentElement.appendChild(content);
    return commentElement;
}

